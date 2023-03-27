package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

import java.util.List;

public class AnswersChat extends Answers {

    @Expose
    private List<ChoicesChat> choices;

    public List<ChoicesChat> getChoices() {
        return choices;
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        for (ChoicesChat ch : choices) {
            answer.append(ch.getMessage().getContent());
            answer.append("\n");
        }
        return answer.toString();
    }
}
