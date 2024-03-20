

package com.senac.MeuDinheiro.controller;

import com.senac.MeuDinheiro.model.Relatorio;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RelatorioController {

    private final Relatorio relatorio;

    public RelatorioController(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    @GetMapping("/relatorios")
    public String gerarRelatorio(Model model) {
        // Configurar o relatório com dados financeiros
        relatorio.setNome("Relatório Financeiro");
        relatorio.setDescricao("Relatório detalhado das finanças");
        relatorio.setDataGeracao(LocalDate.now());
        relatorio.setTotalReceitas(1000.0);
        relatorio.setTotalDespesas(500.0);
        relatorio.setSaldo(500.0);

        // Adicionar o relatório ao modelo
        model.addAttribute("relatorio", relatorio);

        // Retornar a view do relatório
        return "relatorio";
    }
}