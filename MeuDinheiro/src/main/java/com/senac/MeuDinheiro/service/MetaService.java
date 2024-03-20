/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.service;

// src/main/java/com/senac/MeuDinheiro/service/MetaService.java

import com.senac.MeuDinheiro.model.Meta;
import com.senac.MeuDinheiro.model.MetaDriver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Meta } from './meta.entity';

@Injectable()
export class MetaService {
  constructor(
    @InjectRepository(Meta)
    private metaRepository: Repository<Meta>,
  ) {}

  async findAll(): Promise<Meta[]> {
    return this.metaRepository.find();
  }

  async findOne(id: number): Promise<Meta> {
    return this.metaRepository.findOne(id);
  }

  async update(id: number, meta: Meta): Promise<Meta> {
    await this.metaRepository.update(id, meta);
    return this.findOne(id);
  }

  async delete(id: number): Promise<void> {
    await this.metaRepository.delete(id);
  }
}
