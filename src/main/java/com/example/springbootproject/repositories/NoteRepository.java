package com.example.springbootproject.repositories;

import com.example.springbootproject.entities.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
@Repository
public interface NoteRepository extends CrudRepository<Note, UUID> {

    List<Note> findByTitle(String title);
    void deleteAllByCreatedDateBefore(Instant date);
}
