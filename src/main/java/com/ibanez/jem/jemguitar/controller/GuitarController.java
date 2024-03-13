package com.ibanez.jem.jemguitar.controller;

import com.ibanez.jem.jemguitar.model.Guitar;
import com.ibanez.jem.jemguitar.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controller for handling guitar-related requests.
 */
@RestController
@RequestMapping("/api")
public class GuitarController {

    private final GuitarService guitarService;

    /**
     * Constructor for GuitarController.
     *
     * @param guitarService The service that will handle the business logic for guitars.
     */
    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    /**
     * Endpoint for a simple hello message.
     *
     * @return A hello message as a string.
     */
    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return "Hello Guitar Player";
    }

    /**
     * Endpoint to create a new guitar.
     *
     * @param guitar The guitar object to be created.
     * @return The created guitar object.
     */
    @PostMapping("/guitars")
    @ResponseStatus(HttpStatus.CREATED)
    public Guitar createGuitar(@RequestBody Guitar guitar) {
        return guitarService.saveGuitar(guitar);
    }

    /**
     * Endpoint to list all guitars.
     *
     * @return A list of all guitars.
     */
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Guitar> listGuitars() {
        return guitarService.getAllGuitars();
    }

    /**
     * Endpoint to retrieve a guitar by its ID.
     *
     * @param id The UUID of the guitar to retrieve.
     * @return A ResponseEntity containing the guitar or an error message.
     */
    @GetMapping("/guitars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getGuitarById(@PathVariable(value = "id") UUID id) {
        return guitarService.getById(id);
    }

    /**
     * Endpoint to retrieve guitars by their name.
     *
     * @param nome The name of the guitars to search for.
     * @return A list of guitars with the given name.
     */
    @GetMapping("/guitars/search/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Guitar> getGuitarByName(@PathVariable(value = "nome") String nome) {
        return guitarService.getByName(nome);
    }

    /**
     * Endpoint to update an existing guitar.
     *
     * @param id     The UUID of the guitar to update.
     * @param guitar The updated guitar object.
     * @return A ResponseEntity containing the updated guitar or an error message.
     */
    @PutMapping("/guitars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> updateGuitar(@PathVariable(value = "id") UUID id, @RequestBody Guitar guitar) {
        return guitarService.updateGuitar(guitar, id);
    }

    /**
     * Endpoint to delete a guitar by its ID.
     *
     * @param id The UUID of the guitar to delete.
     * @return A ResponseEntity indicating the result of the deletion operation.
     */
    @DeleteMapping("/guitars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteGuitar(@PathVariable(value = "id") UUID id) {
        return guitarService.deleteGuitar(id);
    }
}