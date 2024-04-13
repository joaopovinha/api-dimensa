package com.apidimensa.artifactdimensa.controller;

import com.apidimensa.artifactdimensa.dto.CreateContatoDto;
import com.apidimensa.artifactdimensa.dto.CreateEnderecoDto;
import com.apidimensa.artifactdimensa.dto.UpdateContatoDto;
import com.apidimensa.artifactdimensa.model.Contato;
import com.apidimensa.artifactdimensa.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Tag(name = "Contato")
public class ContatosController {

    private ContatoService contatoService;

    public ContatosController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @Operation(
            description = "POST endpoint for Contatos",
            summary = "Inclui um novo contato no banco"
    )
    @PostMapping
    public ResponseEntity<Contato> createContato(@RequestBody CreateContatoDto createContatoDto){
        var contatoId = contatoService.createContato(createContatoDto);

        return ResponseEntity.created(URI.create("/contato/" + contatoId.toString())).build();
    }

    @Operation(
            description = "POST endpoint for Endereços",
            summary = "A partir do ID do contato, adiciona um endereço"
    )
    @PostMapping("/{contatoId}/endereco")
    public ResponseEntity<Void> createEndereco(@PathVariable("contatoId") Long contatoId, @RequestBody CreateEnderecoDto createEnderecoDto) {
        contatoService.createEndereco(contatoId, createEnderecoDto);

        return ResponseEntity.ok().build();
    }

    @Operation(
            description = "GET endpoint for Contatos - By ID",
            summary = "A partir de um ID, busca os dados de um contato"
    )
    @GetMapping("/{contatoId}")
    public ResponseEntity<Contato> getContatoById(@PathVariable("contatoId") Long contatoId){
        var contato = contatoService.getContatoById(contatoId);

        if(contato.isPresent()) {
            return ResponseEntity.ok(contato.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            description = "GET endpoint for Contatos",
            summary = "Busca todos os contatos cadastrados e seus respectivos endereços"
    )
    @GetMapping()
    public ResponseEntity<List<Contato>> listContatos() {
        var contatos = contatoService.listContatos();

        return ResponseEntity.ok(contatos);
    }

    @Operation(
            description = "PUT endpoint for Contatos",
            summary = "A partir de um ID, altera os dados de um contato"
    )
    @PutMapping("/{contatoId}")
    public ResponseEntity<Void> updateContatoById(@PathVariable("contatoId") Long contatoId, @RequestBody UpdateContatoDto updateContatoDto) {
        contatoService.updateContatoById(contatoId, updateContatoDto);
        return ResponseEntity.noContent().build();
    }
    @Operation(
            description = "DELETE endpoint for Contatos",
            summary = "A partir de um ID, deleta um contato"
    )
    @DeleteMapping("/{contatoId}")
    public ResponseEntity<Void> deleteById(@PathVariable("contatoId") Long contatoId) {
        contatoService.deleteById(contatoId);
        return ResponseEntity.noContent().build();
    }


}
