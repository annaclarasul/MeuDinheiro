/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    public double getCurrentBalance() {
        // Lógica para obter o saldo atual
        return 1000.00;
    }

    public List<String> getRecentExpenses() {
        // Lógica para obter os gastos recentes
        return Arrays.asList("Compra de comida: R$ 50,00", "Pagamento 2: R$ 100,00");
    }

    public List<String> getSavingsGoals() {
        // Lógica para obter as metas de poupança
        return Arrays.asList("Meta 1", "Meta 2", "Meta 3");
    }
}