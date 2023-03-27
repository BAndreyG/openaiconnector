package org.openaiconnector;

import org.openaiconnector.beans.*;
import org.openaiconnector.parsers.Parser;
import org.openaiconnector.senders.ChatSender;
import org.openaiconnector.senders.CompletionsSender;
import org.openaiconnector.senders.Sender;
import org.openaiconnector.utils.Texter;

public class Controller {

    public String getAiAnswer(String modelAI, String question) throws Exception {
        Sender sender;
        switch (modelAI) {
            case Texter.MODEL_NAME_GPT:
                sender = new ChatSender();
                BaseRequest request = new ChatRequest(new Message[]{new Message(question)});
                String req = Parser.parsingTo(request);
                Answers answersChat = (AnswersChat) sender.postTo(req);
                return answersChat.toString();

            case Texter.MODEL_NAME_DAVINCI:
                sender = new CompletionsSender();
                request = new CompletionsRequest(question);
                req = Parser.parsingTo(request);
                Answers answers = (AnswersCompletions) sender.postTo(req);
            default:
                return "Empty";
        }
    }
}
