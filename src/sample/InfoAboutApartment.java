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

import javax.swing.text.Element;
//import javax.swing.text.html.ImageView;

public class InfoAboutApartment {
    private Stage dialogStage;
    private Home home;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    @FXML
    private TextField FloorField;

    @FXML
    private TextField streetField;

    @FXML
    private ImageView imgSet;

    @FXML
    private TextField priceField;

    @FXML
    private TextField squareField;

    @FXML
    private TextField nameField;

    @FXML
    private Button buttonOK;

    @FXML
    private TextField colorField;

    @FXML
    private TextField CityCentreField;
    public void setHome(Apartments home) {
        this.home = home;

        nameField.setText(home.getName());
        colorField.setText(home.getColor());
        squareField.setText(String.valueOf(home.getSquare()));
        priceField.setText(String.valueOf(home.getPrice()));
        streetField.setText(home.getStreet());
        FloorField.setText(String.valueOf(home.getFloor()));
        if (home.getCityCenter())
            CityCentreField.setText("Yes");
        else CityCentreField.setText("No");


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
