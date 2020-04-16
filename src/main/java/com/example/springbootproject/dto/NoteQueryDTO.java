package com.example.springbootproject.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class NoteQueryDTO {

    private UUID id;

    private String noteIdentityNumber;

    private String title;

    private String description;

    private Instant date;

    public NoteQueryDTO(UUID id, String noteIdentityNumber, String title, String description, Instant date) {
        this.id = id;
        this.noteIdentityNumber = noteIdentityNumber;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public String getNoteIdentityNumber() {
        return noteIdentityNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Instant getDate(){
        return date;
    }

    @Override
    public String toString() {
        return "NoteQueryDTO{" +
                "id=" + id +
                ", noteIdentityNumber='" + noteIdentityNumber + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
