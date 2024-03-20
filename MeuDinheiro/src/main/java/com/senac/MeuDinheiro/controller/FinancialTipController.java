/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.controller;

import com.senac.MeuDinheiro.service.FinancialTipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FinancialTipController {

    private final FinancialTipService financialTipService;

    public FinancialTipController(FinancialTipService financialTipService) {
        this.financialTipService = financialTipService;
    }

    @GetMapping("/financial-tip")
    public String getFinancialTip(@RequestParam(value = "income", defaultValue = "0") double income,
                                  @RequestParam(value = "expenses", defaultValue = "0") double expenses,
                                  Model model) {
        String tip = financialTipService.generateTip(income, expenses);
        model.addAttribute("tip", tip);
        return "financial-tip";
    }

}
