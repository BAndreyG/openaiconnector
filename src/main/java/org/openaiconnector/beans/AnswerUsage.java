package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

public class AnswerUsage implements Bean {
    @Expose
    private int prompt_tokens;
    @Expose
    private int completion_tokens;
    @Expose
    private int total_tokens;
}
