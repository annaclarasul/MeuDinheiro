/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.service;


import com.senac.MeuDinheiro.model.Meta;
import java.util.List;

public interface MetaService {
    List<Meta> readAll();
    Meta create(Meta meta);
    Meta update(Meta meta);
    boolean delete(int id);
}