package org.openaiconnector;

import org.openaiconnector.beans.BaseRequest;
import org.openaiconnector.beans.ChatRequest;
import org.openaiconnector.beans.CompletionsRequest;
import org.openaiconnector.beans.Message;
import org.openaiconnector.parsers.Parser;
import org.openaiconnector.senders.ChatSender;
import org.openaiconnector.senders.CompletionsSender;
import org.openaiconnector.senders.Sender;
import org.openaiconnector.utils.Texter;

public class Controller {

    public String getAiAnswer(String modelAI, String question) throws Exception {
        Sender sender;
        String result;
        switch (modelAI) {
            case Texter.MODEL_NAME_GPT:
                sender = new ChatSender();
                BaseRequest request = new ChatRequest(new Message[]{new Message(question)});
                String req = Parser.parsingTo(request);
                result = sender.postTo(req);
                break;
            case Texter.MODEL_NAME_DAVINCI:
                sender = new CompletionsSender();
                request = new CompletionsRequest(question);
                req = Parser.parsingTo(request);
                result = sender.postTo(req);
                break;
            default:
                result = "Empty";
        }
        return result;
    }
}
