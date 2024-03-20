package com.senac.MeuDinheiro.service;

public class FinancialTipService {

    public String generateTip(double income, double expenses) {
        if (expenses / income > 0.5) {
            return "Sua taxa de gastos está muito alta. Tente economizar mais.";
        }

        if (income < 1000) {
            return "Você pode considerar aumentar sua fonte de renda.";
        }

        if (income > 10000) {
            return "Você está fazendo um bom trabalho! Considere investir parte de seu dinheiro.";
        }

        return "Continue a gerenciar suas finanças de forma responsável.";
    }
}