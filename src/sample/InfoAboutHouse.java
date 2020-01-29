package sample;


import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.pojo.Apartments;
import sample.pojo.Home;
import sample.pojo.House;

import javax.swing.text.Element;


public class InfoAboutHouse {
    private Stage dialogStage;
    private Home home;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TextField sqAroundField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField floorField;

    @FXML
    private ImageView imgSet;

    @FXML
    private TextField cityField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField squareField;

    @FXML
    private TextField nameField;

    @FXML
    private Button buttonOK;

    public void setHome(House home) {
this.home=home;

        nameField.setText(home.getName());
        squareField.setText(String.valueOf(home.getSquareAroundHouse()));
        squareField.setText(String.valueOf(home.getSquare()));
        priceField.setText(String.valueOf(home.getPrice()));
        streetField.setText(home.getStreet());
        floorField.setText(String.valueOf(home.getFloor()));
        if (home.isOnCity())
            cityField.setText("Yes");
        else cityField.setText("No");
        sqAroundField.setText(String.valueOf(home.getSquareAroundHouse()));
        System.out.println(home.getPhoto());

        Image image = new Image(getClass().getResource(home.getPhoto()).toExternalForm());

        imgSet.setImage(image);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    void initialize() {



        buttonOK.setOnAction(event -> {
            dialogStage.close();


        });


    }
}