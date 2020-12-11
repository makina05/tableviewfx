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
    private ObservableList<Lag2> zerbitzari;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Lag2> taulaId;

    @FXML
    private TableColumn<Lag2, String> zutId;

    @FXML
    private TableColumn<Lag2, String> servId;

    @FXML
    private TableColumn<Lag2, String> seId;

    @FXML
    void onClick(ActionEvent event) {
        this.kargatuEskaneatutakoak();
        //this.kargatuServerrak();
    }

    @FXML
    void initialize() {

    }
    public void kargatuEskaneatutakoak(){
        List<Lag2> lagak = ServerDBKud.getInstance().lortuEskaneatutakoak();
        data = FXCollections.observableArrayList(lagak);

        zutId.setCellValueFactory( new PropertyValueFactory<>("target"));
        servId.setCellValueFactory( new PropertyValueFactory<>("server"));
        seId.setCellValueFactory( new PropertyValueFactory<>("se"));

        taulaId.setItems(data);

    }
//    public void kargatuServerrak(){
//        List<Lag2> serv = ServerDBKud.getInstance().lortuServerra();
//        zerbitzari = FXCollections.observableArrayList();
//        zerbitzari.addAll(serv);
//        servId.setCellValueFactory( new PropertyValueFactory<>("target"));
//        taulaId.setItems(zerbitzari);
//    }




}
