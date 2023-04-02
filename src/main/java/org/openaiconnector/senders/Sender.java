package org.openaiconnector.senders;

import org.openaiconnector.beans.AnswersByModel;
import org.openaiconnector.beans.Bean;
import org.openaiconnector.parsers.Parser;
import org.openaiconnector.utils.Texter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public interface Sender {

    public String postTo(String request) throws Exception;

    public Bean parsingAnswer(String answer) throws Exception;

    public default HttpURLConnection getGetConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + Texter.KEY);

        return connection;
    }

    public default HttpURLConnection getPostConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + Texter.KEY);
        connection.setDoOutput(true);

        return connection;
    }

    public default HttpURLConnection sendRequest(HttpURLConnection connection, String request) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(request);
        writer.flush();
        writer.close();
        connection.getOutputStream().close();

        return connection;
    }

    public default String getAnswer(HttpURLConnection connection) throws Exception {
        InputStream responseStream = connection.getResponseCode() / 100 == 2
                ? connection.getInputStream()
                : connection.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        connection.disconnect();

        return response;
    }

    public default Bean getMethod() throws Exception {
        URL url = new URL("https://api.openai.com/v1/models");
        HttpURLConnection connection = getGetConnection(url);
        String response = getAnswer(connection);
        AnswersByModel aiModels = (AnswersByModel) Parser.parsingFrom(response, new AnswersByModel());

        return aiModels;
    }


}
