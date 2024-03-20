package com.senac.MeuDinheiro.service;

import com.senac.MeuDinheiro.model.RegistroDeReceitasEDespesas;
import java.util.List;

public interface RegistroDeReceitasEDespesasService {

    List<RegistroDeReceitasEDespesas> listarRegistros();

    RegistroDeReceitasEDespesas salvarRegistro(RegistroDeReceitasEDespesas registro);

}