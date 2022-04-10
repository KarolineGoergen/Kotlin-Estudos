package com.eprogramar.bank.service

import com.eprogramar.bank.model.Pessoa
import com.eprogramar.bank.repository.PessoaRepository
import org.springframework.stereotype.Service
import org.springframework.util.Assert
import java.util.*

@Service
class PessoaServiceImpl(private val repository: PessoaRepository) : PessoaService {
    override fun create(pessoa: Pessoa): Pessoa {
        return repository.save(pessoa)
    }

    override fun getAll(): List<Pessoa> {
        return repository.findAll()
    }

    override fun getById(id: Long): Optional<Pessoa> {
        return repository.findById(id)
    }

    override fun update(id: Long, pessoa: Pessoa): Optional<Pessoa> {
        val optional = getById(id)
        if (optional.isEmpty) {
            return optional
        }

        return optional.map {
            val accountToUpdate = it.copy(
                nome = pessoa.nome,
                email = pessoa.email,
                telefone = pessoa.telefone,
                idade = pessoa.idade
            )
            repository.save(accountToUpdate)
        }
    }

    override fun delete(id: Long) {
        repository.findById(id).map {
            repository.delete(it)
        }.orElseThrow { throw RuntimeException("Id not found $id") }

    }
}