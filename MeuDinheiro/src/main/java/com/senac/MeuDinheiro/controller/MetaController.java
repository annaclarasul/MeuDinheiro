/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.controller;

// src/main/java/com/senac/MeuDinheiro/controller/MetaController.java

import com.senac.MeuDinheiro.model.Meta;
import com.senac.MeuDinheiro.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaController {
    
    @Autowired
    private MetaService metaService;

    @GetMapping
    public List<Meta> getAllMetas() {
        return metaService.readAll();
    }

    @PostMapping
    public Meta createMeta(@RequestBody Meta meta) {
        return metaService.create(meta);
    }

    @PutMapping("/{id}")
    public Meta updateMeta(@PathVariable int id, @RequestBody Meta meta) {
        meta.setId(id);
        return metaService.update(meta);
    }

    @DeleteMapping("/{id}")
    public boolean deleteMeta(@PathVariable int id) {
        return metaService.delete(id);
    }
}
