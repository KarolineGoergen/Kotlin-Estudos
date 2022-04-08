package com.eprogramar.bank.service

import com.eprogramar.bank.model.Pessoa
import java.util.*

interface PessoaService {
    fun create(pessoa: Pessoa): Pessoa

    fun getAll(): List<Pessoa>

    fun getById(id: Long) : Optional<Pessoa>

    fun update(id: Long, pessoa: Pessoa) : Optional<Pessoa>

    fun delete(id: Long)
}