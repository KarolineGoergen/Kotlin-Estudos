package com.eprogramar.bank.repository


import com.eprogramar.bank.model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository

interface PessoaRepository : JpaRepository<Pessoa, Long> {


}
