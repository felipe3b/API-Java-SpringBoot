package com.ibanez.jem.jemguitar.controller;


import com.ibanez.jem.jemguitar.model.Guitar;
import com.ibanez.jem.jemguitar.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GuitarController {

    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    GuitarService guitarService;

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello(){
        return "Hello Guitar Player";
    }

    @PostMapping("/guitars")
    @ResponseStatus(HttpStatus.CREATED)
    public Guitar criarGuitar(@RequestBody Guitar guitar){

        return guitarService.criarGuitar(guitar);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Guitar> listaGuitar(){
        return guitarService.listaGuitar();
    }

    @GetMapping("/guitars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Guitar> buscaGuitarPorId(@PathVariable(value = "id") Long id){
        return guitarService.buscaGuitarPorId(id);
    }

    @GetMapping("/guitars/search/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Guitar> buscaGuitarPorNome(@PathVariable(value = "nome") String nome){
        return guitarService.buscaGuitarPorNome(nome);
    }

}
