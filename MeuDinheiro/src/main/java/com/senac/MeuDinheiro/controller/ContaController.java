/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.controller;

import ch.qos.logback.core.model.Model;
import com.senac.MeuDinheiro.model.Conta;
import com.senac.MeuDinheiro.service.ContaService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping("/listar")
    public String listarContas(@ModelAttribute("contas") List<Conta> contas) {
        contas = contaService.getContas();
        return "contas/listar";
    }

    @GetMapping("/adicionar")
    public String adicionarContaForm(@ModelAttribute("conta") Conta conta) {
        return "contas/adicionar";
    }

    @PostMapping("/adicionar")
    public String adicionarConta(@ModelAttribute("conta") Conta conta) {
        contaService.addConta(conta);
        return "redirect:/contas/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarContaForm(@PathVariable("id") int id, @ModelAttribute("conta") Conta conta) {
        return "contas/editar";
    }

    @PostMapping("/editar/{id}")
    public String editarConta(@ModelAttribute("conta") Conta conta) {
        contaService.updateConta(conta);
        return "redirect:/contas/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluirConta(@PathVariable("id") int id) {
        contaService.deleteConta(id);
        return "redirect:/contas/listar";
    }
}
