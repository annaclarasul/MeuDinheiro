/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.controller;

import com.senac.MeuDinheiro.model.Transacao;
import com.senac.MeuDinheiro.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ModelAndView listarTransacoes() {
        ModelAndView modelAndView = new ModelAndView("transacoes/listar");
        modelAndView.addObject("transacoes", transacaoService.getTransacoes());
        return modelAndView;
    }

    @GetMapping("/nova")
    public ModelAndView novaTransacaoForm() {
        ModelAndView modelAndView = new ModelAndView("transacoes/nova");
        modelAndView.addObject("categorias", transacaoService.getCategorias());
        return modelAndView;
    }

    @PostMapping
    public String adicionarTransacao(@ModelAttribute("transacao") Transacao transacao, BindingResult result) {
        if (result.hasErrors()) {
            return "transacoes/nova";
        }
        transacaoService.addTransacao(transacao);
        return "redirect:/transacoes";
    }

    @GetMapping("/{id}")
    public ModelAndView exibirTransacao(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("transacoes/exibir");
        Transacao transacao = transacaoService.getTransacaoById(id);
        if (transacao == null) {
            return new ModelAndView("redirect:/transacoes");
        }
        modelAndView.addObject("transacao", transacao);
        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editarTransacaoForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("transacoes/editar");
        Transacao transacao = transacaoService.getTransacaoById(id);
        if (transacao == null) {
            return new ModelAndView("redirect:/transacoes");
        }
        modelAndView.addObject("transacao", transacao);
        modelAndView.addObject("categorias", transacaoService.getCategorias());
        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String atualizarTransacao(@PathVariable("id") Long id, @ModelAttribute("transacao") Transacao transacao,
            BindingResult result) {
        if (result.hasErrors()) {
            return "transacoes/editar";
        }
        transacaoService.updateTransacao(id, transacao);
        return "redirect:/transacoes";
    }

    @GetMapping("/{id}/excluir")
    public String excluirTransacao(@PathVariable("id") Long id) {
        Transacao transacao = transacaoService.getTransacaoById(id);
        if (transacao != null) {
            transacaoService.deleteTransacaoById(id);
        }
        return "redirect:/transacoes";
    }
}
