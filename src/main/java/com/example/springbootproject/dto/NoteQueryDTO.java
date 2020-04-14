package com.example.springbootproject.dto;

import java.time.LocalDate;
import java.util.UUID;

public class NoteQueryDTO {

    private UUID id;

    private String noteIdentityNumber;

    private String title;

    private String description;

    private LocalDate date;

    public NoteQueryDTO(UUID id, String noteIdentityNumber, String title, String description, LocalDate date) {
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
