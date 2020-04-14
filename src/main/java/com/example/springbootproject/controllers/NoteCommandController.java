package com.example.springbootproject.controllers;

import com.example.springbootproject.dto.NoteCreateDTO;
import com.example.springbootproject.dto.NoteQueryDTO;
import com.example.springbootproject.dto.NoteUpdateDTO;
import com.example.springbootproject.services.NoteCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/notes")
public class NoteCommandController {

    @Autowired
    private NoteCommandService noteCommandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UUID> createNote(@RequestBody NoteCreateDTO noteCreateDTO) {
        return new ResponseEntity<>(noteCommandService.createNote(noteCreateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UUID> deleteNote(@PathVariable(value = "id") UUID id,
                                           @RequestBody NoteCreateDTO noteCreateDTO) {
        return new ResponseEntity<>(noteCommandService.deleteNote(id, noteCreateDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NoteQueryDTO> updateNote(@PathVariable(value = "id") UUID id,
                                                   @RequestBody NoteUpdateDTO noteUpdateDTO) {
        return new ResponseEntity<>(noteCommandService.updateNote(id, noteUpdateDTO), HttpStatus.OK);
    }
}
