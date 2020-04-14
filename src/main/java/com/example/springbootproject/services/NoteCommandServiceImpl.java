package com.example.springbootproject.services;

import com.example.springbootproject.dto.NoteCreateDTO;
import com.example.springbootproject.dto.NoteQueryDTO;
import com.example.springbootproject.dto.NoteUpdateDTO;
import com.example.springbootproject.entities.Note;
import com.example.springbootproject.entities.Status;
import com.example.springbootproject.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NoteCommandServiceImpl implements NoteCommandService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public UUID createNote(NoteCreateDTO noteCreateDTO) {
        Note note = new Note();

        note.setId(UUID.randomUUID());
        note.setNoteIdentityNumber(noteCreateDTO.getNoteIdentityNumber());
        note.setTitle(noteCreateDTO.getTitle());
        note.setDescription(noteCreateDTO.getDescription());
        note.setDate(noteCreateDTO.getDate());
        note.setStatus(String.valueOf(Status.SCHEDULED));

        return noteRepository.save(note).getId();
    }


    @Override
    public NoteQueryDTO updateNote(UUID id, NoteUpdateDTO noteUpdateDTO) {

        if (noteRepository.findById(id).isPresent()) {
            Note existingNote = noteRepository.findById(id).get();

            existingNote.setTitle(noteUpdateDTO.getTitle());
            existingNote.setDescription(noteUpdateDTO.getDescription());
            existingNote.setDate(noteUpdateDTO.getDate());

            Note updatedNote = noteRepository.save(existingNote);

            return new NoteQueryDTO(updatedNote.getId(), updatedNote.getNoteIdentityNumber(),
                    updatedNote.getTitle(), updatedNote.getDescription(), updatedNote.getDate());
        } else {
            return null;
        }
    }

    public UUID deleteNote(UUID id) {

        if (noteRepository.findById(id).isPresent()) {
            Note existingNote = noteRepository.findById(id).get();

            Note deletedNote = noteRepository.delete(existingNote);



            return null;
        }
}
