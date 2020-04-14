package com.example.springbootproject.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class NoteCreateDTO {
    @Id
    @GeneratedValue
    private String noteIdentityNumber;

    private String title;

    private String description;
    private LocalDate date;

    protected NoteCreateDTO() {
    }

    public NoteCreateDTO(String title, String description, LocalDate date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public String getNoteIdentityNumber() {
        return noteIdentityNumber;
    }

    public void setNoteIdentityNumber(String noteIdentityNumber) {
        this.noteIdentityNumber = noteIdentityNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("Note[noteIdentityNumber=%d, title='%s', description='%s', date='%s']", noteIdentityNumber,
                title, description, date);
    }
}
