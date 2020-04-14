package com.example.springbootproject.services;

import com.example.springbootproject.dto.NoteQueryDTO;
import com.example.springbootproject.entities.Note;
import com.example.springbootproject.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class NoteQueryServiceImpl implements NoteQueryService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public NoteQueryDTO getNote(UUID id) {
        if (noteRepository.findById(id).isPresent()) {
            Note fetchedNote = noteRepository.findById(id).get();
            return new NoteQueryDTO(fetchedNote.getId(), fetchedNote.getNoteIdentityNumber(), fetchedNote.getTitle(),
                    fetchedNote.getDescription(), fetchedNote.getDate());
        } else {
            return null;
        }
    }

    @Override
    public List<NoteQueryDTO> listAllNotes() {
        List<NoteQueryDTO> notelist = new ArrayList<>();

        noteRepository.findAll().forEach(note -> {
            notelist.add(new NoteQueryDTO(note.getId(), note.getNoteIdentityNumber(), note.getTitle(), note.getDescription(), note.getDate()));
        });

        return notelist;
    }
}
