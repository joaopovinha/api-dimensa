package com.apidimensa.artifactdimensa.controller;

import com.apidimensa.artifactdimensa.dto.CreateContatoDto;
import com.apidimensa.artifactdimensa.dto.CreateEnderecoDto;
import com.apidimensa.artifactdimensa.dto.UpdateContatoDto;
import com.apidimensa.artifactdimensa.model.Contato;
import com.apidimensa.artifactdimensa.service.ContatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatosController {

    private ContatoService contatoService;

    public ContatosController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<Contato> createContato(@RequestBody CreateContatoDto createContatoDto){
        var contatoId = contatoService.createContato(createContatoDto);

        return ResponseEntity.created(URI.create("/contato/" + contatoId.toString())).build();
    }

    @GetMapping("/{contatoId}")
    public ResponseEntity<Contato> getContatoById(@PathVariable("contatoId") Long contatoId){
        var contato = contatoService.getContatoById(contatoId);

        if(contato.isPresent()) {
            return ResponseEntity.ok(contato.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Contato>> listContatos() {
        var contatos = contatoService.listContatos();

        return ResponseEntity.ok(contatos);
    }

    @PutMapping("/{contatoId}")
    public ResponseEntity<Void> updateContatoById(@PathVariable("contatoId") Long contatoId, @RequestBody UpdateContatoDto updateContatoDto) {
        contatoService.updateContatoById(contatoId, updateContatoDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{contatoId}")
    public ResponseEntity<Void> deleteById(@PathVariable("contatoId") Long contatoId) {
        contatoService.deleteById(contatoId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{contatoId}/endereco")
    public ResponseEntity<Void> createEndereco(@PathVariable("contatoId") Long contatoId, @RequestBody CreateEnderecoDto createEnderecoDto) {
        contatoService.createEndereco(contatoId, createEnderecoDto);

        return ResponseEntity.ok().build();
    }


}
