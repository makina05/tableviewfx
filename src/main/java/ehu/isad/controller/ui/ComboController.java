package ehu.isad.controller.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.db.EurobisioaDBKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ComboController {
    private Main main;
    public String aukera;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboId;

    @FXML
    private Button btnCombo;

    @FXML
    public void onClick(ActionEvent event) {
        main.aukeratutaErakutsi();
    }

    @FXML
    public void initialize() {
        List<String> herrialdeakList = EurobisioaDBKud.getInstance().lortuHerrialdeak();
        ObservableList<String> herrialdeak = FXCollections.observableArrayList(herrialdeakList);

        comboId.setItems(herrialdeak);
        aukera = comboId.getValue();

    }
    public void setMainApp(Main main){
        this.main = main;
    }
}
