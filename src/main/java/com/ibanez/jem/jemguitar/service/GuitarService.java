package com.ibanez.jem.jemguitar.service;

import com.ibanez.jem.jemguitar.model.Guitar;
import com.ibanez.jem.jemguitar.repository.GuitarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarService {

    public GuitarService(GuitarRepository guitarRepository) {

        this.guitarRepository = guitarRepository;
    }

    private final GuitarRepository guitarRepository;

    public Guitar criarGuitar(Guitar guitar) {

        return guitarRepository.save(guitar);
    }

    public List<Guitar> listaGuitar() {
        return guitarRepository.findAll();
    }

    public ResponseEntity<Guitar> buscaGuitarPorId(Long id) {
        return guitarRepository.findById(id)
                .map(guitar -> ResponseEntity.ok().body(guitar))
                .orElse(ResponseEntity.notFound().build());
    }

    public List<Guitar> buscaGuitarPorNome(String nome) {
        return guitarRepository.findByNome(nome);
    }
}
