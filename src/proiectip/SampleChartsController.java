/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectip;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;

/**
 *
 * @author John
 */
public class SampleChartsController implements Initializable {
    
    enum tipStatistica{
        statisticaHarta,
        statisticaInstoric,
        statisticaEmotii
    }
    private tipStatistica statistica = tipStatistica.statisticaHarta;
    
    @FXML
    private ListView userListView;
    @FXML
    private Button importButton;
    @FXML
    private Button totalsButton;
    @FXML
    private ToggleButton mapsButton;
    @FXML
    private ToggleButton historyButton;
    @FXML
    private ToggleButton emotionsButton;
    @FXML
    private HBox buttonListBox; 
    
    
    
    @FXML
    private void importData(ActionEvent event) {
        System.out.println("Importa datele...");
        
        dataImported();
    }
    
    @FXML
    private void showMaps(ActionEvent event) {
        System.out.println("Arata harta...");
        mapsButton.setDisable(true);
        historyButton.setDisable(false);
        emotionsButton.setDisable(false);
        
    }
    
    @FXML
    private void showHistory(ActionEvent event) {
        System.out.println("Arata istoric...");
        mapsButton.setDisable(false);
        historyButton.setDisable(true);
        emotionsButton.setDisable(false);
        
    }
    
    @FXML
    private void showEmotions(ActionEvent event) {
        System.out.println("Arata emotii...");
        mapsButton.setDisable(false);
        historyButton.setDisable(false);
        emotionsButton.setDisable(true);
        
    }
    
    private void dataImported() {
        importButton.setVisible(false);
        totalsButton.setDisable(false);
        buttonListBox.setDisable(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        totalsButton.setDisable(true);
        buttonListBox.setDisable(true);
    }    
}
