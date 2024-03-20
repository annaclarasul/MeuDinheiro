
package com.senac.MeuDinheiro.service;

import com.senac.MeuDinheiro.model.Relatorio;
import java.time.LocalDate;
import java.util.List;

public interface RelatorioService {

    List<Relatorio> gerarRelatorios();
}
