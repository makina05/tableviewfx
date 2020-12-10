package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.db.WhatWebDBKud;
import ehu.isad.model.Laguntzailea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class CMSController {
    private ObservableList<Laguntzailea> data;
    private ObservableList<Laguntzailea> data2;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLupa;

    @FXML
    private ComboBox<?> comboBoxId;

    @FXML
    private Button btnAddURL;

    @FXML
    private TableView<Laguntzailea> tableViewId;

    @FXML
    private TextField fieldId;

    @FXML
    private TableColumn<Laguntzailea, String> urlId;

    @FXML
    private TableColumn<Laguntzailea, String> cmsId;

    @FXML
    private TableColumn<Laguntzailea, String> versionId;

    @FXML
    private TableColumn<Laguntzailea, String> lastId;

    @FXML
    void initialize() {

    }

    @FXML
    void onClickLupa(ActionEvent event) {
        this.filtratu();
    }

    public void kargatuTaula(){
        List<Laguntzailea> lagak = WhatWebDBKud.getInstance().lortuOrrialdeak();
        data = FXCollections.observableArrayList(lagak);

        urlId.setCellValueFactory( new PropertyValueFactory<>("target"));
        versionId.setCellValueFactory( new PropertyValueFactory<>("version"));
        cmsId.setCellValueFactory( new PropertyValueFactory<>("string"));
        lastId.setCellValueFactory( new PropertyValueFactory<>("target_id"));

        tableViewId.setItems(data);

    }

    public void filtratu(){
        String textua = fieldId.getText();
        List<Laguntzailea> lista = WhatWebDBKud.getInstance().lortuOrrialdeak();
        List<Laguntzailea> listaFiltratua=new ArrayList<>();
        for (int i=0;i<lista.size();i++){
            if (lista.get(i).getTarget().contains(textua)){
                listaFiltratua.add(lista.get(i));
            }
        }
        data2 = FXCollections.observableArrayList(listaFiltratua);
        tableViewId.setItems(data2);
    }
}
