package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

public class Error implements Bean {
    @Expose
    private String type;
    @Expose
    private String message;

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
