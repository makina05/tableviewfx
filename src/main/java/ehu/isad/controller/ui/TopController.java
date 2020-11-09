package ehu.isad.controller.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.db.EurobisioaDBKud;
import ehu.isad.model.HerrialdeModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

public class TopController {
private Main main;
private List<String> lista;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<HerrialdeModel> taula;

    @FXML
    private TableColumn<HerrialdeModel, String > herrialdea;

    @FXML
    private TableColumn<HerrialdeModel, Integer> puntuak;


    @FXML
    void initialize() {
//        lista = EurobisioaDBKud.getInstance().lortuTopa();
//        taula.setEditable(true);
//
//        herrialdea.setCellValueFactory(new PropertyValueFactory<>("izena"));
//        puntuak.setCellValueFactory(new PropertyValueFactory<>("puntuak"));

    }
    public void setMainApp(Main main){
        this.main = main;
    }
}
