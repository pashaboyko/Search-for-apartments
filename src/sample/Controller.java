package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.pojo.Apartments;
import sample.pojo.Home;
import sample.pojo.House;

import java.io.IOException;

public class Controller {



    public ObservableList<Home> productsData = FXCollections.observableArrayList();
    public ObservableList<House> productsData2 = FXCollections.observableArrayList();


    @FXML
    private TableView<Home> tableUsers;


    @FXML
    private TableColumn<Home, Integer> idColumn;

    @FXML
    private TableColumn<Home, String> nameColumn;

    @FXML
    private TableColumn<Home, String> streetColum;
    @FXML
    private TableColumn<Home, Double> priceColumn;

    @FXML
    private CheckBox checkHo;

    @FXML
    private CheckBox checkApp;

    @FXML
    private TextField priceField;

    @FXML
    private Button allOption;
    @FXML
    private Label errorText;

    @FXML
    private Button buttonOK;

    @FXML
    private TextField sizeField;



    @FXML
    private void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<Home, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Home, String>("name"));
        streetColum.setCellValueFactory(new PropertyValueFactory<Home, String>("street"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Home, Double>("price"));

        listfortovar.prdd.add(new Apartments(9, "BananHouse", "Kolonina", 160000, 80, "9", 10, "Balck&Yelow,",true));


        tableUsers.setItems(productsData);

        buttonOK.setOnAction(event -> {
            errorText.setText(" ");
            tableUsers.refresh();
            productsData.clear();
            listfortovar.prdd.clear();
            listfortovar.prdp.clear();
            Connectionn b = new Connectionn();
            b.addtoProgramm();

            if(priceField.getText().isEmpty()||sizeField.getText().isEmpty()){// ВИКЛЮЧНІ СТАНИ
                errorText.setText("Please fill in all required fields");
            }
            else {
                if (checkApp.isSelected() && !(checkHo.isSelected())) {
                    for (int i = 0; i < listfortovar.prdd.size(); i++) {
                        if ((Double.valueOf(priceField.getText()) - 2001) < listfortovar.prdd.get(i).getPrice() && (Double.valueOf(priceField.getText()) + 2001) > listfortovar.prdd.get(i).getPrice()) {
                            if ((Double.valueOf(sizeField.getText()) - 21) < listfortovar.prdd.get(i).getSquare() && (Double.valueOf(sizeField.getText()) + 21) > listfortovar.prdd.get(i).getSquare()) {

                                productsData.add((listfortovar.prdd.get(i)));
                                System.out.println(listfortovar.prdd.get(i).getStreet());
                            }
                        }
                    }
                } else {
                    if (!(checkApp.isSelected()) && checkHo.isSelected()) {
                        for (int i = 0; i < listfortovar.prdp.size(); i++) {
                            if ((Double.valueOf(priceField.getText()) - 2001) < listfortovar.prdp.get(i).getPrice() && (Double.valueOf(priceField.getText()) + 2001) > listfortovar.prdp.get(i).getPrice()) {
                                if ((Double.valueOf(sizeField.getText()) - 41) < listfortovar.prdp.get(i).getSquare() && (Double.valueOf(sizeField.getText()) + 41) > listfortovar.prdp.get(i).getSquare()) {

                                    productsData.add(listfortovar.prdp.get(i));
                                }
                            }
                        }
                    } else {
                        for (int i = 0; i < listfortovar.prdp.size(); i++) {
                            if ((Double.valueOf(priceField.getText()) - 2001) < listfortovar.prdp.get(i).getPrice() && (Double.valueOf(priceField.getText()) + 2001) > listfortovar.prdp.get(i).getPrice()) {
                                if ((Double.valueOf(sizeField.getText()) - 41) < listfortovar.prdp.get(i).getSquare() && (Double.valueOf(sizeField.getText()) + 41) > listfortovar.prdp.get(i).getSquare()) {

                                    productsData.add(listfortovar.prdp.get(i));
                                }
                            }
                        }
                        for (int i = 0; i < listfortovar.prdd.size(); i++) {
                            if ((Double.valueOf(priceField.getText()) - 2001) < listfortovar.prdd.get(i).getPrice() && (Double.valueOf(priceField.getText()) + 2001) > listfortovar.prdd.get(i).getPrice()) {
                                if ((Double.valueOf(sizeField.getText()) - 21) < listfortovar.prdd.get(i).getSquare() && (Double.valueOf(sizeField.getText()) + 21) > listfortovar.prdd.get(i).getSquare()) {

                                    productsData.add(listfortovar.prdd.get(i));

                                }
                            }

                        }
                    }
                }
            }

                    priceField.clear();
                    sizeField.clear();
            });



        allOption.setOnAction(event -> {
                    tableUsers.refresh();
                    productsData.clear();
                    listfortovar.prdd.clear();
            listfortovar.prdp.clear();
                    Connectionn b = new Connectionn();
                    b.addtoProgramm();
                    for (int i = 0; i < listfortovar.prdd.size(); i++){
                        productsData.add((listfortovar.prdd.get(i)));}
                    for (int i = 0; i < listfortovar.prdp.size(); i++){
                        productsData.add(listfortovar.prdp.get(i));
            System.out.println(listfortovar.prdp.size());}

                    });







        tableUsers.setRowFactory(tv -> {
            TableRow<Home> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Home rowData = row.getItem();

                    showPersonEditDialog(rowData);
                }
            });
            return row;
        });
    }
    public boolean showPersonEditDialog(Home home) {
        Stage dialogStage = new Stage();
        try {
            System.out.println(home.getStreet());
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            System.out.println(home.getClass().getName());
            if(home.getClass().getName() == "sample.pojo.Apartments"){
            loader.setLocation(getClass().getResource("infoAboutApartment.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            System.out.println(home.getClass().getName());
            // Create the dialog Stage.

            dialogStage.setTitle("Info");
            dialogStage.initModality(Modality.WINDOW_MODAL);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            InfoAboutApartment controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setHome((Apartments)home);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            return true;}
            else{
if (home.getClass().getName() == "sample.pojo.House"){
        loader.setLocation(getClass().getResource("infoAboutHouse.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        System.out.println(home.getClass().getName());
        // Create the dialog Stage.

        dialogStage.setTitle("Info");
        dialogStage.initModality(Modality.WINDOW_MODAL);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Set the person into the controller.
        InfoAboutHouse controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setHome((House)home);
        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();
        return true;}
else{ return false;}
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

}