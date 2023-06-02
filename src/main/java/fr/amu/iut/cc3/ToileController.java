package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    @FXML
    TextField c1TextField;
    @FXML
    TextField c2TextField;
    @FXML
    TextField c3TextField;
    @FXML
    TextField c4TextField;
    @FXML
    TextField c5TextField;
    @FXML
    TextField c6TextField;

    @FXML
    Circle point1;
    @FXML
    Circle point2;
    @FXML
    Circle point3;
    @FXML
    Circle point4;
    @FXML
    Circle point5;
    @FXML
    Circle point6;

    @FXML
    private void tracerClicked() {
        float numberC1;
        float numberC2;
        float numberC3;
        float numberC4;
        float numberC5;
        float numberC6;

        //C1
        if (c1TextField.getText().isEmpty()) {
            numberC1 = 0;
            c1TextField.setText("0");
        }
        else {
            numberC1 = Integer.parseInt(c1TextField.getText());
        }
        point1.setCenterX(getXRadarChart(numberC1, 1));
        point1.setCenterY(getYRadarChart(numberC1,1));

        //C2
        if (c2TextField.getText().isEmpty()) {
            numberC2 = 0;
            c2TextField.setText("0");
        }
        else {
            numberC2 = Integer.parseInt(c2TextField.getText());
        }
        point2.setCenterX(getXRadarChart(numberC2, 2));
        point2.setCenterY(getYRadarChart(numberC2,2));

        //C3
        if (c3TextField.getText().isEmpty()) {
            numberC3 = 0;
            c3TextField.setText("0");
        }
        else {
            numberC3 = Integer.parseInt(c3TextField.getText());
        }
        point3.setCenterX(getXRadarChart(numberC3,3));
        point3.setCenterY(getYRadarChart(numberC3,3));

        //C4
        if (c4TextField.getText().isEmpty()) {
            numberC4 = 0;
            c4TextField.setText("0");
        }
        else {
            numberC4 = Integer.parseInt(c4TextField.getText());
        }
        point4.setCenterX(getXRadarChart(numberC4,4));
        point4.setCenterY(getYRadarChart(numberC4,4));

        //C5
        if (c5TextField.getText().isEmpty()) {
            numberC5 = 0;
            c5TextField.setText("0");
        }
        else {
            numberC5 = Integer.parseInt(c5TextField.getText());
        }
        point5.setCenterX(getXRadarChart(numberC5,5));
        point5.setCenterY(getYRadarChart(numberC5,5));

        //C6
        if (c6TextField.getText().isEmpty()) {
            numberC6 = 0;
            c6TextField.setText("0");
        }
        else {
            numberC6 = Integer.parseInt(c6TextField.getText());
        }
        point6.setCenterX(getXRadarChart(numberC6,6));
        point6.setCenterY(getYRadarChart(numberC6,6));
    }

    public static void numericOnly(final TextField field) {
        field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(
                    ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    field.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numericOnly(c1TextField);
        numericOnly(c2TextField);
        numericOnly(c3TextField);
        numericOnly(c4TextField);
        numericOnly(c5TextField);
        numericOnly(c6TextField);
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

}
