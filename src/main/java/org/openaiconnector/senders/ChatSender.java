package org.openaiconnector.senders;

import org.openaiconnector.beans.*;
import org.openaiconnector.parsers.Parser;

import java.net.HttpURLConnection;
import java.net.URL;

public class ChatSender implements Sender {
    @Override
    public Bean postTo(String request) throws Exception {
        URL url = new URL("https://api.openai.com/v1/chat/completions");
        HttpURLConnection connection = getPostConnection(url);

        sendRequest(connection, request);

        return parsingAnswer(getAnswer(connection));
    }

    @Override
    public Bean parsingAnswer(String answer) throws Exception {
        return Parser.parsingFrom(answer, new AnswersChat(), "");
    }
}
