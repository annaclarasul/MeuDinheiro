/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.service;

// src/main/java/com/senac/MeuDinheiro/service/MetaService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetaService {
    @Autowired
    private MetaDriver metaDriver;

    public Meta create(Meta meta) {
        return metaDriver.create(meta);
    }

    public List<Meta> readAll() {
        return metaDriver.readAll();
    }
