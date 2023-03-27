package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

public class Message implements Bean {
    @Expose
    private String role;
    @Expose
    private String content;

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public Message(String content) {
        this.role = "user";
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }

}
