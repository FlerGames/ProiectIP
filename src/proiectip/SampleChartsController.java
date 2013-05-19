/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectip;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import models.Comment;

/**
 *
 * @author John
 */
public class SampleChartsController implements Initializable {
    
    ArrayList<Comment> comments;
    ArrayList<String> authors;
    
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
    private StackPane mainPane;
    
    @FXML
    private void importData(ActionEvent event) {
        System.out.println("Importa datele...");
        
        authors = new ArrayList<>();
        comments = XMLParser.importData();
        for (Comment comment : comments) {
            if (!authors.contains(comment.getAuthor())) {
                userListView.getItems().add(comment.getAuthor());
                authors.add(comment.getAuthor());
            }
        }
        
        importButton.setVisible(false);
        totalsButton.setDisable(false);
        buttonListBox.setDisable(false);
        
        showEmotions(null);
    }
    
    @FXML
    private void showMaps(ActionEvent event) {
        System.out.println("Arata harta...");
        mapsButton.setDisable(true);
        historyButton.setDisable(false);
        emotionsButton.setDisable(false);
        
        mainPane.getChildren().clear();
        
    }
    
    @FXML
    private void showHistory(ActionEvent event) {
        System.out.println("Arata istoric...");
        mapsButton.setDisable(false);
        historyButton.setDisable(true);
        emotionsButton.setDisable(false);
        
        mainPane.getChildren().clear();
        
    }
    
    @FXML
    private void showEmotions(ActionEvent event) {
        System.out.println("Arata emotii...");
        mapsButton.setDisable(false);
        historyButton.setDisable(false);
        emotionsButton.setDisable(true);
        
        mainPane.getChildren().clear();
        
        int pozitive = 0;
        int negative = 0;
        int neutre = 0;
        
        for (Comment comment : comments) {
            switch (comment.getType()) {
                case "positiv":
                    pozitive++;
                    break;
                case "neutru":
                    neutre++;
                    break;
                default:
                    negative++;
                    break;
            }
        }
        
        CategoryAxis xAxis = new CategoryAxis();
//        xAxis.setCategories(FXCollections.observableArrayList(years));
        NumberAxis yAxis = new NumberAxis();//"Units Sold", 0.0d, 3000.0d, 1000.0d);
        ObservableList barChartData = FXCollections.observableArrayList(
                new BarChart.Series("Pozitive", FXCollections.observableArrayList(
                        new BarChart.Data("Pozitive", pozitive)
                )),
                new BarChart.Series("Neutre", FXCollections.observableArrayList(
                    new BarChart.Data("Neutre", neutre)
                )),
                new BarChart.Series("Negative", FXCollections.observableArrayList(
                    new BarChart.Data("Negative", negative)
                ))
        );
        BarChart chart = new BarChart(xAxis, yAxis, barChartData);
//        chart.setAnimated(true);
        chart.setVerticalGridLinesVisible(false);
        
        
        mainPane.getChildren().add(chart);
    }
    
    private void authorSelected(ActionEvent event) {
        System.out.println("Autor selectat...");
        String author = (String) userListView.getSelectionModel().getSelectedItem();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        totalsButton.setDisable(true);
        buttonListBox.setDisable(true);
        
        userListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                authorSelected(null);
            }
        });
    }    
}
