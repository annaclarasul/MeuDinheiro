/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.controller;

import ch.qos.logback.core.model.Model;
import com.senac.MeuDinheiro.model.RegistroDeReceitasEDespesas;
import com.senac.MeuDinheiro.service.RegistroDeReceitasEDespesasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/registros")
public class RegistroDeReceitasEDespesasController {

    @Autowired
    private RegistroDeReceitasEDespesasService registroService;

    @GetMapping("")
    public ModelAndView listarRegistros() {
        List<RegistroDeReceitasEDespesas> registros = registroService.listarRegistros();
        ModelAndView mav = new ModelAndView("registros/lista");
        mav.addObject("registros", registros);
        return mav;
    }

    @GetMapping("/novo")
    public ModelAndView mostrarFormularioDeCadastro() {
        RegistroDeReceitasEDespesas registro = new RegistroDeReceitasEDespesas();
        ModelAndView mav = new ModelAndView("registros/formulario");
        mav.addObject("registro", registro);
        return mav;
    }

    @PostMapping("/salvar")
    public String salvarRegistro(@ModelAttribute("registro") RegistroDeReceitasEDespesas registro) {
        registroService.salvarRegistro(registro);
        return "redirect:/registros";
    }
}
