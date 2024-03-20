/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.controller;

import ch.qos.logback.core.model.Model;
import com.senac.MeuDinheiro.service.DashboardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public ModelAndView showDashboard() {
        double currentBalance = dashboardService.getCurrentBalance();
        List<String> recentExpenses = dashboardService.getRecentExpenses();
        List<String> savingsGoals = dashboardService.getSavingsGoals();

        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("currentBalance", currentBalance);
        modelAndView.addObject("recentExpenses", recentExpenses);
        modelAndView.addObject("savingsGoals", savingsGoals);

        return modelAndView;
    }
}