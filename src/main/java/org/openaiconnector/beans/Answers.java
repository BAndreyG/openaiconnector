package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

public abstract class Answers implements Bean {
    @Expose
    private String id;
    @Expose
    private String object;
    @Expose
    private String created;
    @Expose
    private String model;
    @Expose
    private AnswerUsage usage;
}
