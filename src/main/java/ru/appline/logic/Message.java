package ru.appline.logic;

public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public Message() {
        super();
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
