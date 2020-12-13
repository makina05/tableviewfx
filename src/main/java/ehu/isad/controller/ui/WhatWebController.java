package ehu.isad.controller.ui;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import ehu.isad.Main;
import ehu.isad.db.DBKudeatzaile;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class WhatWebController {
    private Main main;
    private String uri;
    private String non;

    @FXML
    private ResourceBundle resources;

    @FXML
    private CMSController cmsController;

    @FXML
    private URL location;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btn;

    @FXML
    private TextField txtF;

    @FXML
    void onclick(ActionEvent event) {
        //whatweb erlaitzeko web orriaren analisiak emandako emaitza hemen kudeatzen da

        txtArea.setWrapText(true);
        txtArea.setText("Kargatzen. Itxaron, mesedez....");
        uri = txtF.getText();


        Thread taskThread = new Thread( () -> {

            String newLine = System.getProperty("line.separator");
            final StringBuilder emaitza = new StringBuilder();
            try {
                allProcesses().forEach( line ->  {
                    emaitza.append( line + newLine );
                });
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            txertatuDBn();

            Platform.runLater( () -> {
                txtArea.setText(emaitza.toString());


            } );

        });

        taskThread.start();


    }

    private void txertatuDBn() {
        // setup properties sqlPath kargatzen da
        // sql fitxategia lerroz lerro irakurri
            // lerroa.replace(" IGNORE", " OR IGNORE")
            // exekutatu lerroa sqliten (insert)
        // sqlPath ezabatu

        DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
        String line;
        BufferedReader input =
                null;
        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream(new File("c:" + non))));
            while ((line = input.readLine()) != null) {
                line = line.replace(" IGNORE", " OR IGNORE");
                dbk.execSQL(line);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        deleteFile("c:" + non);

    }
    private boolean deleteFile(String filePath) {
        if (filePath == null) {
            return true;
        }
        File file = new File(filePath);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }


    @FXML
    void initialize() {

    }

    public List<String> allProcesses() throws IOException {

        Properties properties = new Properties();
        InputStream in = null;
        in = this.getClass().getResourceAsStream("/setup.properties");
        properties.load(in);
        non = properties.getProperty("sqlPath");

        List<String> processes = new LinkedList<String>();
        try {
            String line;
            Process p = null;
            if(System.getProperty("os.name").toLowerCase().contains("win")) { //windows bada OSa
                System.out.println(uri);
        String komandoa = "wsl /usr/bin/whatweb --color=never --log-sql=/mnt/c"+ non +" "+ uri;
                // DONE: sqlPath pasatu parametro gisa
                p = Runtime.getRuntime().exec
                        (komandoa);

            } else { //Linux baldin bada OSa
                p = Runtime.getRuntime().exec("/usr/bin/whatweb --color=never --log-sql=" + non +" "+ uri);
            }
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                processes.add(line);
            }
            System.out.println(processes);
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }

        return processes;
    }


//    public void setMainApp(Main main){
//        this.main = main;
//    }
}