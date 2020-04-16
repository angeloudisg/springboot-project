package com.example.springbootproject;

import com.example.springbootproject.entities.Note;
import com.example.springbootproject.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class SpringBootProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }

}

@Component
class DemoCommandLineRunner implements CommandLineRunner {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void run(String... args) throws Exception {

        Note english = new Note();
        english.setId(UUID.randomUUID());
        english.setNoteIdentityNumber("#1234");
        english.setTitle("English");
        english.setDescription("Learn how to speak English fluently");
        english.setDate(Instant.now());

        noteRepository.save(english);

        Note biology = new Note();
        biology.setId(UUID.randomUUID());
        biology.setNoteIdentityNumber("5678");
        biology.setTitle("Biology");
        biology.setDescription("Learn about DNA");
        english.setDate(Instant.MIN);

        noteRepository.save(biology);
    }
}