package com.ibanez.jem.jemguitar.service;

import com.ibanez.jem.jemguitar.model.Guitar;
import com.ibanez.jem.jemguitar.repository.GuitarRepository;
import org.springframework.stereotype.Service;

@Service
public class GuitarService {

    public GuitarService(GuitarRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }

    private final GuitarRepository guitarRepository;

    public Guitar criarGuitar(Guitar guitar){
        return guitarRepository.save(guitar);
    }

}
