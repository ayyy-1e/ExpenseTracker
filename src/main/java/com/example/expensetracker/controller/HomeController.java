package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final ExpenseRepository expenseRepository;

    public HomeController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        double total = expenseRepository.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();

        model.addAttribute("expenses", expenseRepository.findAll());
        model.addAttribute("expense", new Expense());
        model.addAttribute("total", total);
        return "index";
    }

    @PostMapping("/add")
    public String addExpense(@ModelAttribute Expense expense) {
        expenseRepository.save(expense);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
        return "redirect:/";
    }
}