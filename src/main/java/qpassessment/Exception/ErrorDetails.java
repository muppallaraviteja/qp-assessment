package qpassessment.Exception;

import java.time.LocalDate;

public class ErrorDetails {
    private String description;
    private String message;
    private LocalDate date;

    public ErrorDetails(String description, String message, LocalDate date) {
        this.description = description;
        this.message = message;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
