package com.ibanez.jem.jemguitar.service;

import com.ibanez.jem.jemguitar.model.Guitar;
import com.ibanez.jem.jemguitar.repository.GuitarRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GuitarService {

    public GuitarService(GuitarRepository guitarRepository) {

        this.guitarRepository = guitarRepository;
    }

    private final GuitarRepository guitarRepository;

    public Guitar saveGuitar(Guitar guitar) {

        return guitarRepository.save(guitar);
    }

    public List<Guitar> getAllGuitars() {
        return guitarRepository.findAll();
    }

    public ResponseEntity<Object> getById(UUID id) {
        var guitarOptional = guitarRepository.findById(id);

        if (guitarOptional.isPresent()) {
            return ResponseEntity.ok(guitarOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Guitar not found");
        }
    }

    public List<Guitar> getByName(String nome) {
        return guitarRepository.findByNome(nome);
    }

    public ResponseEntity<Object> updateGuitar(Guitar guitar, UUID id) {
        var guitarOptional = guitarRepository.findById(id);

        if (guitarOptional.isPresent()) {
            var guitarToUpdate = guitarOptional.get();
            guitarToUpdate.setNome(guitar.getNome());
            guitarToUpdate.setModelo(guitar.getModelo());
            guitarToUpdate.setPreco(guitar.getPreco());
            Guitar updated = guitarRepository.save(guitarToUpdate);

            return ResponseEntity.ok().body(updated);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Guitar not found");

    }

    public ResponseEntity<Object> deleteGuitar(UUID id) {
        var guitarOptional = guitarRepository.findById(id);

        if (guitarOptional.isPresent()) {
            guitarRepository.delete(guitarOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Guitar deleted successfully.");

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Guitar not found");

    }
}
