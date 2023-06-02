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
import javafx.scene.control.Label;
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
    Label erreurLabel;

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


        //C2
        if (c2TextField.getText().isEmpty()) {
            numberC2 = 0;
            c2TextField.setText("0");
        }
        else {
            numberC2 = Integer.parseInt(c2TextField.getText());
        }


        //C3
        if (c3TextField.getText().isEmpty()) {
            numberC3 = 0;
            c3TextField.setText("0");
        }
        else {
            numberC3 = Integer.parseInt(c3TextField.getText());
        }


        //C4
        if (c4TextField.getText().isEmpty()) {
            numberC4 = 0;
            c4TextField.setText("0");
        }
        else {
            numberC4 = Integer.parseInt(c4TextField.getText());
        }


        //C5
        if (c5TextField.getText().isEmpty()) {
            numberC5 = 0;
            c5TextField.setText("0");
        }
        else {
            numberC5 = Integer.parseInt(c5TextField.getText());
        }


        //C6
        if (c6TextField.getText().isEmpty()) {
            numberC6 = 0;
            c6TextField.setText("0");
        }
        else {
            numberC6 = Integer.parseInt(c6TextField.getText());
        }

        if (!(((numberC1 < 0) || (numberC1 > 20))
                || ((numberC2 < 0) || (numberC2 > 20))
                || ((numberC3 < 0) || (numberC3 > 20))
                || ((numberC4 < 0) || (numberC4 > 20))
                || ((numberC5 < 0) || (numberC5 > 20))
                || ((numberC6 < 0) || (numberC6 > 20)))) {

            erreurLabel.setText("");

            point1.setCenterX(getXRadarChart(numberC1, 1));
            point1.setCenterY(getYRadarChart(numberC1,1));

            point2.setCenterX(getXRadarChart(numberC2, 2));
            point2.setCenterY(getYRadarChart(numberC2,2));

            point3.setCenterX(getXRadarChart(numberC3,3));
            point3.setCenterY(getYRadarChart(numberC3,3));

            point4.setCenterX(getXRadarChart(numberC4,4));
            point4.setCenterY(getYRadarChart(numberC4,4));

            point5.setCenterX(getXRadarChart(numberC5,5));
            point5.setCenterY(getYRadarChart(numberC5,5));

            point6.setCenterX(getXRadarChart(numberC6,6));
            point6.setCenterY(getYRadarChart(numberC6,6));
        }
        else {

            erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");

        }

    }

    @FXML
    private void viderClicked() {
        c1TextField.setText("");
        c2TextField.setText("");
        c3TextField.setText("");
        c4TextField.setText("");
        c5TextField.setText("");
        c6TextField.setText("");

        point1.setCenterX(getXRadarChart(0, 1));
        point1.setCenterY(getYRadarChart(0,1));

        point2.setCenterX(getXRadarChart(0, 2));
        point2.setCenterY(getYRadarChart(0,2));

        point3.setCenterX(getXRadarChart(0,3));
        point3.setCenterY(getYRadarChart(0,3));

        point4.setCenterX(getXRadarChart(0,4));
        point4.setCenterY(getYRadarChart(0,4));

        point5.setCenterX(getXRadarChart(0,5));
        point5.setCenterY(getYRadarChart(0,5));

        point6.setCenterX(getXRadarChart(0,6));
        point6.setCenterY(getYRadarChart(0,6));

        erreurLabel.setText("");

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
