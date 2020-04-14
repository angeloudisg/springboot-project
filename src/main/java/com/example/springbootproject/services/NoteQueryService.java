package com.example.springbootproject.services;

import com.example.springbootproject.dto.NoteQueryDTO;

import java.util.List;
import java.util.UUID;

public interface NoteQueryService {

    public NoteQueryDTO getNote(UUID id);

    public List<NoteQueryDTO> listAllNotes();
}