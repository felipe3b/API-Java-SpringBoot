package com.ibanez.jem.jemguitar.controller;

import com.ibanez.jem.jemguitar.model.Guitar;
import com.ibanez.jem.jemguitar.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class GuitarController {

    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    GuitarService guitarService;

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return "Hello Guitar Player";
    }

    @PostMapping("/guitars")
    @ResponseStatus(HttpStatus.CREATED)
    public Guitar createGuitar(@RequestBody Guitar guitar) {
        return guitarService.saveGuitar(guitar);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Guitar> listGuitars() {
        return guitarService.getAllGuitars();
    }

    @GetMapping("/guitars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getGuitarById(@PathVariable(value = "id") UUID id) {
        return guitarService.getById(id);
    }

    @GetMapping("/guitars/search/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Guitar> getGuitarByName(@PathVariable(value = "nome") String nome) {
        return guitarService.getByName(nome);
    }

    @PutMapping("/guitars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> updateGuitar(@PathVariable(value = "id") UUID id, @RequestBody Guitar guitar) {
        return guitarService.updateGuitar(guitar, id);
    }

    @DeleteMapping("/guitars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteGuitar(@PathVariable(value = "id") UUID id){
        return guitarService.deleteGuitar(id);
     }



}
