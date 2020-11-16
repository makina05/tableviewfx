package ehu.isad.controller.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import ehu.isad.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class HasieraController {
    private Main main;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btn;

    @FXML
    void onclick(ActionEvent event) {

        txtArea.setWrapText(true);
        txtArea.setText("Kargatzen. Itxaron, mesedez....");


        Thread taskThread = new Thread( () -> {

            String newLine = System.getProperty("line.separator");
            final StringBuilder emaitza = new StringBuilder();
            allProcesses().forEach( line ->  {
                emaitza.append( line + newLine );
            });

            Platform.runLater( () -> {
                txtArea.setText(emaitza.toString());

                //txertatu();

            } );

        });

        taskThread.start();

    }


    @FXML
    void initialize() {

    }

    public List<String> allProcesses() {
        List<String> processes = new LinkedList<String>();
        try {
            String line;
            Process p = null;
            if(System.getProperty("os.name").toLowerCase().contains("win")) {
                p = Runtime.getRuntime().exec
                        (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            } else {
                p = Runtime.getRuntime().exec("ps -e");
            }
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                processes.add(line);
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }

        return processes;
    }


    public void setMainApp(Main main){
        this.main = main;
    }
}