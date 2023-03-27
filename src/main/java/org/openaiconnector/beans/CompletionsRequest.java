package org.openaiconnector.beans;

import org.openaiconnector.utils.Texter;

public class CompletionsRequest extends BaseRequest {
    private int max_tokens;
    private String prompt;

    public CompletionsRequest(String model, double temperature, int max_tokens, String prompt) {
        super(model, temperature);
        this.max_tokens = max_tokens;
        this.prompt = prompt;
    }

    public CompletionsRequest(String prompt) {
        super(Texter.MODEL_NAME_DAVINCI, Texter.DEFAULT_TEMPERATURE);
        this.max_tokens = Texter.MAX_TOKENS;
        this.prompt = prompt;
    }

    public int getMax_tokens() {
        return max_tokens;
    }

    public String getPrompt() {
        return prompt;
    }
}
