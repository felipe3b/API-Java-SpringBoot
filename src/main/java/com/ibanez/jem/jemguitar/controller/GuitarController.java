package com.ibanez.jem.jemguitar.controller;


import com.ibanez.jem.jemguitar.model.Guitar;
import com.ibanez.jem.jemguitar.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GuitarController {

    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello(){
        return "Hello Guitar Player";
    }

    GuitarService guitarService;
    @PostMapping("/guitars")
    @ResponseStatus(HttpStatus.CREATED)
    public Guitar criarGuitar(@RequestBody Guitar guitar){
        return guitarService.criarGuitar(guitar);
    }

}
