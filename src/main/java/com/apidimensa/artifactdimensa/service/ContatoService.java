package com.apidimensa.artifactdimensa.service;

import com.apidimensa.artifactdimensa.dto.CreateContatoDto;
import com.apidimensa.artifactdimensa.dto.CreateEnderecoDto;
import com.apidimensa.artifactdimensa.dto.UpdateContatoDto;
import com.apidimensa.artifactdimensa.model.Contato;
import com.apidimensa.artifactdimensa.model.Endereco;
import com.apidimensa.artifactdimensa.repository.ContatoRepository;
import com.apidimensa.artifactdimensa.repository.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    private ContatoRepository contatoRepository;

    private EnderecoRepository enderecoRepository;

    public ContatoService(ContatoRepository contatoRepository, EnderecoRepository enderecoRepository) {
        this.contatoRepository = contatoRepository;
        this.enderecoRepository = enderecoRepository;
    }




    public Long createContato(CreateContatoDto createContatoDto) {

        // DTO -> ENTITY
        var entity = new Contato(null, createContatoDto.nome(), createContatoDto.email(), createContatoDto.telefone(), createContatoDto.dataNascimento());

        var contatoSaved = contatoRepository.save(entity);

        return contatoSaved.getContatoId();
    }

    public Optional<Contato> getContatoById (Long contatoId) {

        return contatoRepository.findById(contatoId);
    }

    public List<Contato> listContatos() {
        return contatoRepository.findAll();
    }

    public void deleteById(Long contatoId) {
        var contatoExists = contatoRepository.existsById(contatoId);

        if(contatoExists) {
            contatoRepository.deleteById(contatoId);
        }
    }

    public void updateContatoById(Long contatoId, UpdateContatoDto updateContatoDto) {
        var contatoEntity = contatoRepository.findById(contatoId);

        if (contatoEntity.isPresent()) {
            var contato = contatoEntity.get();

            if (updateContatoDto.nome() != null) {
                contato.setNome(updateContatoDto.nome());
            }

            if (updateContatoDto.email() != null) {
                contato.setEmail(updateContatoDto.email());
            }

            if (updateContatoDto.telefone() != null) {
                contato.setTelefone(updateContatoDto.telefone());
            }

            if (updateContatoDto.dataNascimento() != null) {
                contato.setDataNascimento(updateContatoDto.dataNascimento());
            }

            contatoRepository.save(contato);
        }
    }

    public void createEndereco(Long contatoId, CreateEnderecoDto createEnderecoDto) {

        var contato = contatoRepository.findById(contatoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // DTO -> ENTITY
        var endereco = new Endereco(null, contato, createEnderecoDto.rua(), createEnderecoDto.numero(), createEnderecoDto.cep());

        var enderecoCreated = enderecoRepository.save(endereco);
    }

}
