#!/usr/bin/env bash
set -euo pipefail

# Robust wrapper to find the built jar (supports single-module and multi-module)
# and run it. If no jar exists, it will attempt to build with Gradle.

echo "railway-start: locating jar..."

# enable globstar on bash if available
if shopt -s globstar 2>/dev/null; then :; fi
shopt -s nullglob 2>/dev/null || true

find_jars() {
  local arr
  arr=(build/libs/*.jar */build/libs/*.jar **/build/libs/*.jar)
  printf "%s\n" "${arr[@]}"
}

jar=$(find_jars | xargs -r ls -1t 2>/dev/null | head -n1 || true)

if [ -z "${jar}" ]; then
  echo "No jar found; attempting to build with Gradle..."
  if [ -x ./gradlew ]; then
    ./gradlew clean bootJar --no-daemon
  elif command -v gradle >/dev/null 2>&1; then
    gradle clean bootJar --no-daemon
  else
    echo "No Gradle wrapper or gradle available to build the project." >&2
  fi
  jar=$(find_jars | xargs -r ls -1t 2>/dev/null | head -n1 || true)
fi

if [ -z "${jar}" ]; then
  echo "Error: no jar found in build/libs; build may have failed." >&2
  exit 1
fi

echo "Starting application from: ${jar}"
exec java -jar "${jar}" "$@"
