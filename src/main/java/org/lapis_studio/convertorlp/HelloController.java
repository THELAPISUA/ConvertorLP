package org.lapis_studio.convertorlp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ChoiceButton;

    @FXML
    private Button ConvertButton;

    @FXML
    private Label OutputPathLabel;

    @FXML
    private Label PathLabel;

    @FXML
    void initialize() {
        assert ChoiceButton != null : "fx:id=\"ChoiceButton\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert ConvertButton != null : "fx:id=\"ConvertButton\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert OutputPathLabel != null : "fx:id=\"OutputPathLabel\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert PathLabel != null : "fx:id=\"PathLabel\" was not injected: check your FXML file 'hello-view.fxml'.";
    }

    @FXML
    protected void onChoiceButtonClick() {
        PathLabel.setText("Path is work!");
    }
}