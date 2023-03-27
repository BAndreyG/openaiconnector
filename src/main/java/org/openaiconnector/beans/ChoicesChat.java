package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

public class ChoicesChat extends Choices {
    @Expose
    private Message message;

    public Message getMessage() {
        return message;
    }
}
