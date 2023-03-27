package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

public class ChoicesCompletions extends Choices {
    @Expose
    private String text;
    @Expose
    private String logprobs;

    public String getText() {
        return text;
    }

    public String getLogprobs() {
        return logprobs;
    }
}
