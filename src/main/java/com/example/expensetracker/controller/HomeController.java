package com.example.expensetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.expensetracker.model.Expense;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.ArrayList;

@Controller
public class HomeController {

    private List<Expense> expenses = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("expenses", expenses);
        model.addAttribute("expense", new Expense());
        return "index";
    }

    @PostMapping("/add")
    public String addExpense(@ModelAttribute Expense expense) {
        expenses.add(expense);
        return "redirect:/";
    }

}
