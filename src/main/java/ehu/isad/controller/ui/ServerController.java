package ehu.isad.controller.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.db.ServerDBKud;
import ehu.isad.db.WhatWebDBKud;
import ehu.isad.model.Lag2;
import ehu.isad.model.Laguntzailea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ServerController {
    private ObservableList<Lag2> data;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Lag2> taulaId;

    @FXML
    private TableColumn<Lag2, String> zutId;

    @FXML
    void onClick(ActionEvent event) {
        this.kargatuEskaneatutakoak();
    }

    @FXML
    void initialize() {

    }
    public void kargatuEskaneatutakoak(){
        List<Lag2> lagak = ServerDBKud.getInstance().lortuEskaneatutakoak();
        data = FXCollections.observableArrayList();
        data.addAll(lagak);
        zutId.setCellValueFactory( new PropertyValueFactory<>("target"));

        taulaId.setItems(data);
    }




}
