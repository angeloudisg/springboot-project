package com.example.springbootproject.services;

import com.example.springbootproject.dto.NoteCreateDTO;
import com.example.springbootproject.dto.NoteDeleteDTO;
import com.example.springbootproject.dto.NoteQueryDTO;
import com.example.springbootproject.dto.NoteUpdateDTO;

import java.util.UUID;

public interface NoteCommandService {
    public UUID createNote(NoteCreateDTO noteCreateDTO);

    public void deleteNote(UUID id, NoteDeleteDTO noteDeleteDTO) throws Exception;

    public NoteQueryDTO updateNote(UUID id, NoteUpdateDTO noteUpdateDTO);
}
