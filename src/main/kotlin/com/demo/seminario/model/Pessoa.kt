package com.eprogramar.bank.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "pessoa")
data class Pessoa(
        @Id @GeneratedValue
        var id: Long? = null,
        val nome: String,
        val email: String,
        val telefone: String,
        val idade: Long
)