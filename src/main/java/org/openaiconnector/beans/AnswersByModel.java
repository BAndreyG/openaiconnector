package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

import java.util.List;

public class AnswersByModel implements Bean {
    @Expose
    private List<AiModel> data;

    public List<AiModel> getData() {
        return data;
    }
}
