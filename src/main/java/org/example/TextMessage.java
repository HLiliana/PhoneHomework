package org.example;

public class TextMessage {
    private String contact;
    private String content;

    public TextMessage(String contact, String content) {
        this.contact = contact;
        this.content = content;
    }

    public String getContact() {
        return contact;
    }

    public String getContent() {
        return content;
    }
}

