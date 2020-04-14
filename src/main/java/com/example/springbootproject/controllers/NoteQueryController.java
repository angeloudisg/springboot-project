package com.example.springbootproject.controllers;

import com.example.springbootproject.dto.NoteQueryDTO;
import com.example.springbootproject.services.NoteQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/notes")
public class NoteQueryController {

    @Autowired
    private NoteQueryService noteQueryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<NoteQueryDTO>> listAllNotes() {
        return new ResponseEntity<>(noteQueryService.listAllNotes(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NoteQueryDTO> getNote(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<>(noteQueryService.getNote(id), HttpStatus.OK);
    }
}
