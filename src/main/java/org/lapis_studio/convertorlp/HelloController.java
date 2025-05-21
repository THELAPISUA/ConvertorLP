package org.lapis_studio.convertorlp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class HelloController {


    @FXML
    private Button ChoiceButton;

    @FXML
    private Button ConvertButton;

    @FXML
    private Label OutputPathLabel;

    @FXML
    private Label PathLabel;

    @FXML
    private RadioButton radioJPEG;

    @FXML
    private RadioButton radioJPG;

    @FXML
    private RadioButton radioPNG;



    File selectedFile;
    String pathOut;
    @FXML
    protected void onChoiceButtonClick() {
        Stage primaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choice photo");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("PNG JPG JPEG зображення", "*.png","*.jpg","*.jpeg")
        );
        selectedFile = fileChooser.showOpenDialog(primaryStage);

        PathLabel.setText(selectedFile.getPath());
        pathOut = selectedFile.getParent();
        OutputPathLabel.setText(pathOut);
    }

    @FXML
    protected void oConvertButtonClick() throws IOException {
        if (selectedFile == null || pathOut == null) {
            System.out.println("File select error.");
            return;
        }

        BufferedImage image = ImageIO.read(selectedFile);
        if (radioJPG.isSelected()) {
            File outputFile = new File(pathOut + File.separator + "output.jpg");
            ImageIO.write(toBufferedImage(image, BufferedImage.TYPE_INT_RGB), "jpg", outputFile);
        }

        if (radioPNG.isSelected()) {
            File outputFile = new File(pathOut + File.separator + "output.png");
            ImageIO.write(image, "png", outputFile);
        }

        if (radioJPEG.isSelected()) {
            File outputFile = new File(pathOut + File.separator + "output.jpeg");
            ImageIO.write(toBufferedImage(image, BufferedImage.TYPE_INT_RGB), "jpeg", outputFile);
        }
    }
    private BufferedImage toBufferedImage(BufferedImage src, int type) {
        BufferedImage image = new BufferedImage(src.getWidth(), src.getHeight(), type);
        image.getGraphics().drawImage(src, 0, 0, null);
        return image;
    }
}