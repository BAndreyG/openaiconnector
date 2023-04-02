package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

public class AnswerError implements Bean {
    @Expose
    private Error error;

    public Error getError() {
        return error;
    }

    @Override
    public String toString() {
        return "AnswerError{" + "error: type = " + error.getType() + ", message = " + error.getMessage() + '}';
    }
}
