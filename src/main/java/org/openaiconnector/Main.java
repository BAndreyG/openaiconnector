package org.openaiconnector;

import org.openaiconnector.beans.*;
import org.openaiconnector.parsers.Parser;
import org.openaiconnector.senders.ChatSender;
import org.openaiconnector.senders.CompletionsSender;
import org.openaiconnector.senders.Sender;
import org.openaiconnector.ui.MainForm;

import static javafx.application.Application.launch;


public class Main {

    public static void main(String[] args) {

        try {
            MainForm ui = new MainForm();
            ui.go(args);

            Sender sender = new ChatSender();
            BaseRequest request = new ChatRequest(new Message[]{new Message("Сколько футов в аршине?")});
            String req = Parser.parsingTo(request);
            Answers answersChat = (AnswersChat) sender.postTo(req);
            System.out.println(answersChat.toString());

            sender = new CompletionsSender();
            request = new CompletionsRequest("Сколько футов в аршине?");
            req = Parser.parsingTo(request);
            Answers answers = (AnswersCompletions) sender.postTo(req);
            System.out.println(answers.toString());

//            AnswersByModel aiModel = (AnswersByModel) sender.getMethod();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}