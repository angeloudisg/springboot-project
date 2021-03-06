package com.example.springbootproject.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class NoteUpdateDTO {
    private String title;

    private String description;
    private Instant date;

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

    public void setDate(Instant date) {
        this.date = date;
    }

    public Instant getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("Note[title='%s', description='%s', date='%s']", title, description, date);
    }
}
