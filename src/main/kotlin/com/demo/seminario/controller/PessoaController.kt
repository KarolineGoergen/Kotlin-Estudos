package com.eprogramar.bank.controller


import com.eprogramar.bank.model.Pessoa
import com.eprogramar.bank.service.PessoaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoa")
class PessoaController(private val service: PessoaService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody pessoa: Pessoa): Pessoa = service.create(pessoa)

    @GetMapping
    fun getAll(): List<Pessoa> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<Pessoa> =
            service.getById(id).map {
                ResponseEntity.ok(it)
            }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody pessoa: Pessoa) : ResponseEntity<Pessoa> =
            service.update(id, pessoa).map {
                ResponseEntity.ok(it)
            }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity<Void>(HttpStatus.OK)
    }
}