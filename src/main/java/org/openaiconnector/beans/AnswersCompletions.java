package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

import java.util.List;

public class AnswersCompletions extends Answers {
    @Expose
    private List<ChoicesCompletions> choices;

    public List<ChoicesCompletions> getChoices() {
        return choices;
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        for (ChoicesCompletions ch : choices) {
            answer.append(ch.getText());
            answer.append("\n");
        }
        return answer.toString();
    }
}
