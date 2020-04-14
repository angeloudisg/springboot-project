package com.example.springbootproject.repositories;

import com.example.springbootproject.entities.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends CrudRepository<Note, UUID> {

    List<Note> findByTitle(@Param("title") String title);
}
