/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.service;

import com.senac.MeuDinheiro.model.Conta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContaService {

    private List<Conta> contas;

    public ContaService() {
        contas = new ArrayList<>();
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void addConta(Conta conta) {
        contas.add(conta);
    }

    public Conta getContaById(int id) {
        for (Conta conta : contas) {
            if (conta.getId() == id) {
                return conta;
            }
        }
        return null;
    }

    public void updateConta(Conta conta) {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getId() == conta.getId()) {
                contas.set(i, conta);
                break;
            }
        }
    }

    public void deleteConta(int id) {
        if (contas != null) {
            Iterator<Conta> iterator = contas.iterator();
            while (iterator.hasNext()) {
                Conta conta = iterator.next();
                if (conta.id == id) {
                    iterator.remove();
                    break;
                }
            }
        }
    }

}
