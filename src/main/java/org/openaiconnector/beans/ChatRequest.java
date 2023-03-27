package org.openaiconnector.beans;

import org.openaiconnector.utils.Texter;

public class ChatRequest extends BaseRequest {
    private Message[] messages;

    public ChatRequest(String model, Message[] messages, double temperature) {
        super(model, temperature);
        this.messages = messages;
    }

    public ChatRequest(Message[] messages) {
        super(Texter.MODEL_NAME_GPT, Texter.DEFAULT_TEMPERATURE);
        this.messages = messages;
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public double getTemperature() {
        return super.getTemperature();
    }

    public Message[] getMessages() {
        return messages;
    }

}
