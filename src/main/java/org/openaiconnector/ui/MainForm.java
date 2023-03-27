package org.openaiconnector.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.openaiconnector.Controller;
import org.openaiconnector.utils.Texter;

public class MainForm extends javafx.application.Application {
    private int maxX = 700;
    private int maxY = 500;
    private Controller controller = new Controller();
    private StringBuilder answers = new StringBuilder();

    public void go(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        primaryStage.setTitle("Connect with OpenAI");

        // создание компонентов формы
        Label modelAILabel = new Label("Model AI");
        modelAILabel.setLayoutX(10);
        modelAILabel.setLayoutY(10);
        Label label = new Label("Answers from AI");
        label.setLayoutX(maxX / 2 - 50);
        label.setLayoutY(10);

        ObservableList<String> items = FXCollections.observableArrayList(Texter.MODEL_NAME_GPT, Texter.MODEL_NAME_DAVINCI);
        ComboBox<String> comboBox = new ComboBox<>(items);
        comboBox.getSelectionModel().selectFirst(); // Selects the first item in the list
        comboBox.setLayoutX(10);
        comboBox.setLayoutY(30);

        TextArea response = new TextArea();
        response.setLayoutX(150);
        response.setLayoutY(30);
        response.setPrefWidth(maxX - 110);
        response.setPrefHeight(maxY - 110);
        response.setText("sdfsdsdfsdfsdf df sdf sdf");

        TextField request = new TextField();
        request.setLayoutX(10);
        request.setLayoutY(maxY - 60);
        request.setPrefWidth(maxX - 20);

        Button button = new Button("Send");
        button.setLayoutX(10);
        button.setLayoutY(maxY - 40);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String requestText = request.getText();
                String modelAI = comboBox.getSelectionModel().getSelectedItem();
                try {
                    answers.append(controller.getAiAnswer(modelAI, requestText));
                    answers.append("\n");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                response.setText(answers.toString());
            }
        });

        // добавление компонентов на панель

        Pane root = new Pane();
        root.getChildren().addAll(modelAILabel, label, response, request, button, comboBox);

        // установка панели на сцену
        Scene scene = new Scene(root, maxX, maxY);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
