package ehu.isad.controller.ui;

import java.net.URL;
import java.util.*;

import ehu.isad.db.WhatWebDBKud;
import ehu.isad.model.Cms;
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
    private ObservableList<Laguntzailea> data3;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private ComboBox<String> comboBoxId;

    @FXML
    private Button btnAddURL;



    @FXML
    void onClickLupa(ActionEvent event) {
        this.filtratu();
    }

    @FXML
    void aukeratuta(ActionEvent event) {
        //this.filtratuCombotik();
    }

    @FXML
    public void initialize(){

        List<String> cl = new ArrayList<>();
        cl.add("WordPress");
        cl.add("Joomla");
        cl.add("Drupal");
        cl.add("phpMyAdmin");
        ObservableList<String> cmsak = FXCollections.observableArrayList(cl);
        comboBoxId.setItems(cmsak);
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
        String izena = comboBoxId.getValue();
        List<Laguntzailea> lista = WhatWebDBKud.getInstance().lortuOrrialdeak();
        List<Laguntzailea> listaFiltratua=new ArrayList<>();
        for (int i=0;i<lista.size();i++){
            if (lista.get(i).getTarget().contains(textua) && lista.get(i).getString().contains(izena)){
                listaFiltratua.add(lista.get(i));
            }
        }
        data2 = FXCollections.observableArrayList(listaFiltratua);
        tableViewId.setItems(data2);
    }

//    public void filtratuCombotik(){
//        String izena = comboBoxId.getValue();
//        List<Laguntzailea> lista = WhatWebDBKud.getInstance().lortuOrrialdeak();
//        List<Laguntzailea> listaFiltratuaCombotik=new ArrayList<>();
//        for (int i=0;i<lista.size();i++){
//            if (lista.get(i).getString().contains(izena)){
//                listaFiltratuaCombotik.add(lista.get(i));
//            }
//        }
//        data3 = FXCollections.observableArrayList(listaFiltratuaCombotik);
//        tableViewId.setItems(data3);
//    }
}
