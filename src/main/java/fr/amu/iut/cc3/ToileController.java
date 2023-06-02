package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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
    private TextField c1TextField;
    @FXML
    private TextField c2TextField;
    @FXML
    private TextField c3TextField;
    @FXML
    private TextField c4TextField;
    @FXML
    private TextField c5TextField;
    @FXML
    private TextField c6TextField;

    @FXML
    private Circle point1;
    @FXML
    private Circle point2;
    @FXML
    private Circle point3;
    @FXML
    private Circle point4;
    @FXML
    private Circle point5;
    @FXML
    private Circle point6;

    @FXML
    private Line ligne1a2;
    @FXML
    private Line ligne2a3;
    @FXML
    private Line ligne3a4;
    @FXML
    private Line ligne4a5;
    @FXML
    private Line ligne5a6;
    @FXML
    private Line ligne6a1;

    @FXML
    private Label erreurLabel;

    @FXML
    private void tracerClicked() {
        int numberC1;
        int numberC2;
        int numberC3;
        int numberC4;
        int numberC5;
        int numberC6;


        //C1
        if (c1TextField.getText().isEmpty()) {
            numberC1 = 0;
        }
        else {
            numberC1 = Integer.parseInt(c1TextField.getText());
        }

        //C2
        if (c2TextField.getText().isEmpty()) {
            numberC2 = 0;
        }
        else {
            numberC2 = Integer.parseInt(c2TextField.getText());
        }


        //C3
        if (c3TextField.getText().isEmpty()) {
            numberC3 = 0;
        }
        else {
            numberC3 = Integer.parseInt(c3TextField.getText());
        }


        //C4
        if (c4TextField.getText().isEmpty()) {
            numberC4 = 0;
        }
        else {
            numberC4 = Integer.parseInt(c4TextField.getText());
        }


        //C5
        if (c5TextField.getText().isEmpty()) {
            numberC5 = 0;
        }
        else {
            numberC5 = Integer.parseInt(c5TextField.getText());
        }


        //C6
        if (c6TextField.getText().isEmpty()) {
            numberC6 = 0;
        }
        else {
            numberC6 = Integer.parseInt(c6TextField.getText());
        }

        if ( !((numberC1 < 0) || (numberC1 > 20)
            || (numberC2 < 0) || (numberC2 > 20)
            || (numberC3 < 0) || (numberC3 > 20)
            || (numberC4 < 0) || (numberC4 > 20)
            || (numberC5 < 0) || (numberC5 > 20)
            || (numberC6 < 0) || (numberC6 > 20))) {

            // Lignes

            ligne1a2.setStartX(getXRadarChart(numberC1, 1));
            ligne1a2.setStartY(getYRadarChart(numberC1, 1));
            ligne1a2.setEndX(getXRadarChart(numberC2, 2));
            ligne1a2.setEndY(getYRadarChart(numberC2, 2));

            ligne2a3.setStartX(getXRadarChart(numberC2, 2));
            ligne2a3.setStartY(getYRadarChart(numberC2, 2));
            ligne2a3.setEndX(getXRadarChart(numberC3, 3));
            ligne2a3.setEndY(getYRadarChart(numberC3, 3));

            ligne3a4.setStartX(getXRadarChart(numberC3, 3));
            ligne3a4.setStartY(getYRadarChart(numberC3, 3));
            ligne3a4.setEndX(getXRadarChart(numberC4, 4));
            ligne3a4.setEndY(getYRadarChart(numberC4, 4));

            ligne4a5.setStartX(getXRadarChart(numberC4, 4));
            ligne4a5.setStartY(getYRadarChart(numberC4, 4));
            ligne4a5.setEndX(getXRadarChart(numberC5, 5));
            ligne4a5.setEndY(getYRadarChart(numberC5, 5));

            ligne5a6.setStartX(getXRadarChart(numberC5, 5));
            ligne5a6.setStartY(getYRadarChart(numberC5, 5));
            ligne5a6.setEndX(getXRadarChart(numberC6, 6));
            ligne5a6.setEndY(getYRadarChart(numberC6, 6));

            ligne6a1.setStartX(getXRadarChart(numberC6, 6));
            ligne6a1.setStartY(getYRadarChart(numberC6, 6));
            ligne6a1.setEndX(getXRadarChart(numberC1, 1));
            ligne6a1.setEndY(getYRadarChart(numberC1, 1));

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

        erreurLabel.setText("");

        ligne1a2.setStartX(getXRadarChart(0,1));
        ligne1a2.setStartY(getYRadarChart(0,1));
        ligne1a2.setEndX(getXRadarChart(0,2));
        ligne1a2.setEndY(getYRadarChart(0,2));

        ligne2a3.setStartX(getXRadarChart(0,2));
        ligne2a3.setStartY(getYRadarChart(0,2));
        ligne2a3.setEndX(getXRadarChart(0,3));
        ligne2a3.setEndY(getYRadarChart(0,3));

        ligne3a4.setStartX(getXRadarChart(0,3));
        ligne3a4.setStartY(getYRadarChart(0,3));
        ligne3a4.setEndX(getXRadarChart(0,4));
        ligne3a4.setEndY(getYRadarChart(0,4));

        ligne4a5.setStartX(getXRadarChart(0,4));
        ligne4a5.setStartY(getYRadarChart(0,4));
        ligne4a5.setEndX(getXRadarChart(0,5));
        ligne4a5.setEndY(getYRadarChart(0,5));

        ligne5a6.setStartX(getXRadarChart(0,5));
        ligne5a6.setStartY(getYRadarChart(0,5));
        ligne5a6.setEndX(getXRadarChart(0,6));
        ligne5a6.setEndY(getYRadarChart(0,6));

        ligne6a1.setStartX(getXRadarChart(0,6));
        ligne6a1.setStartY(getYRadarChart(0,6));
        ligne6a1.setEndX(getXRadarChart(0,1));
        ligne6a1.setEndY(getYRadarChart(0,1));

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

        //C1
        IntegerBinding bindingX1 = new IntegerBinding() {
            {
                this.bind(c1TextField.textProperty());
            }
            @Override
            protected int computeValue() {
                int number;
                if (c1TextField.getText().isEmpty()) {
                    number = 0;

                }
                else {
                    number = Integer.parseInt(c1TextField.getText());
                    if ((number < 0) || (number > 20)) {
                        erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");
                        number = 0;

                    }
                    else {
                        erreurLabel.setText("");
                    }
                }
                return getXRadarChart(number, 1);
            }
        };

        IntegerBinding bindingY1 = new IntegerBinding() {
            {
                this.bind(c1TextField.textProperty());
            }
            @Override
            protected int computeValue() {
                int number;
                if (c1TextField.getText().isEmpty()) {
                    number = 0;

                }
                else {
                    number = Integer.parseInt(c1TextField.getText());
                    if ((number < 0) || (number > 20)) {
                        erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");
                        number = 0;

                    }
                    else {
                        erreurLabel.setText("");
                    }
                }
                return getYRadarChart(number, 1);
            }
        };


        //C2
        IntegerBinding bindingX2 = new IntegerBinding() {
            {
                this.bind(c2TextField.textProperty());
            }
            @Override
            protected int computeValue() {
                int number;
                if (c2TextField.getText().isEmpty()) {
                    number = 0;

                }
                else {
                    number = Integer.parseInt(c2TextField.getText());
                    if ((number < 0) || (number > 20)) {
                        erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");
                        number = 0;

                    }
                    else {
                        erreurLabel.setText("");
                    }
                }
                return getXRadarChart(number, 2);
            }
        };

        IntegerBinding bindingY2 = new IntegerBinding() {
            {
                this.bind(c2TextField.textProperty());
            }
            @Override
            protected int computeValue() {
                int number;
                if (c2TextField.getText().isEmpty()) {
                    number = 0;

                }
                else {
                    number = Integer.parseInt(c2TextField.getText());
                    if ((number < 0) || (number > 20)) {
                        erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");
                        number = 0;

                    }
                    else {
                        erreurLabel.setText("");
                    }
                }
                return getYRadarChart(number, 2);
            }
        };

        //C3
        IntegerBinding bindingX3 = new IntegerBinding() {
            {
                this.bind(c3TextField.textProperty());
            }
            @Override
            protected int computeValue() {
                int number;
                if (c3TextField.getText().isEmpty()) {
                    number = 0;

                }
                else {
                    number = Integer.parseInt(c3TextField.getText());
                    if ((number < 0) || (number > 20)) {
                        erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");
                        number = 0;

                    }
                    else {
                        erreurLabel.setText("");
                    }
                }
                return getXRadarChart(number, 3);
            }
        };

        IntegerBinding bindingY3 = new IntegerBinding() {
            {
                this.bind(c3TextField.textProperty());
            }
            @Override
            protected int computeValue() {
                int number;
                if (c3TextField.getText().isEmpty()) {
                    number = 0;

                }
                else {
                    number = Integer.parseInt(c3TextField.getText());
                    if ((number < 0) || (number > 20)) {
                        erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");
                        number = 0;

                    }
                    else {
                        erreurLabel.setText("");
                    }
                }
                return getYRadarChart(number, 3);
            }
        };

        //C4
        IntegerBinding bindingX4 = new IntegerBinding() {
            {
                this.bind(c4TextField.textProperty());
            }
            @Override
            protected int computeValue() {
                int number;
                if (c4TextField.getText().isEmpty()) {
                    number = 0;

                }
                else {
                    number = Integer.parseInt(c4TextField.getText());
                    if ((number < 0) || (number > 20)) {
                        erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");
                        number = 0;

                    }
                    else {
                        erreurLabel.setText("");
                    }
                }
                return getXRadarChart(number, 4);
            }
        };

        IntegerBinding bindingY4 = new IntegerBinding() {
            {
                this.bind(c4TextField.textProperty());
            }
            @Override
            protected int computeValue() {
                int number;
                if (c4TextField.getText().isEmpty()) {
                    number = 0;

                }
                else {
                    number = Integer.parseInt(c4TextField.getText());
                    if ((number < 0) || (number > 20)) {
                        erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");
                        number = 0;

                    }
                    else {
                        erreurLabel.setText("");
                    }
                }
                return getYRadarChart(number, 4);
            }
        };

        //C5
        IntegerBinding bindingX5 = new IntegerBinding() {
            {
                this.bind(c5TextField.textProperty());
            }
            @Override
            protected int computeValue() {
                int number;
                if (c5TextField.getText().isEmpty()) {
                    number = 0;

                }
                else {
                    number = Integer.parseInt(c5TextField.getText());
                    if ((number < 0) || (number > 20)) {
                        erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");
                        number = 0;

                    }
                    else {
                        erreurLabel.setText("");
                    }
                }
                return getXRadarChart(number, 5);
            }
        };

        IntegerBinding bindingY5 = new IntegerBinding() {
            {
                this.bind(c5TextField.textProperty());
            }
            @Override
            protected int computeValue() {
                int number;
                if (c5TextField.getText().isEmpty()) {
                    number = 0;

                }
                else {
                    number = Integer.parseInt(c5TextField.getText());
                    if ((number < 0) || (number > 20)) {
                        erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");
                        number = 0;

                    }
                    else {
                        erreurLabel.setText("");
                    }
                }
                return getYRadarChart(number, 5);
            }
        };

        //C6
        IntegerBinding bindingX6 = new IntegerBinding() {
            {
                this.bind(c6TextField.textProperty());
            }
            @Override
            protected int computeValue() {
                int number;
                if (c6TextField.getText().isEmpty()) {
                    number = 0;

                }
                else {
                    number = Integer.parseInt(c6TextField.getText());
                    if ((number < 0) || (number > 20)) {
                        erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");
                        number = 0;

                    }
                    else {
                        erreurLabel.setText("");
                    }
                }
                return getXRadarChart(number, 6);
            }
        };

        IntegerBinding bindingY6 = new IntegerBinding() {
            {
                this.bind(c6TextField.textProperty());
            }
            @Override
            protected int computeValue() {
                int number;
                if (c6TextField.getText().isEmpty()) {
                    number = 0;

                }
                else {
                    number = Integer.parseInt(c6TextField.getText());
                    if ((number < 0) || (number > 20)) {
                        erreurLabel.setText("Les valeurs doivent \nêtre entre 0 et 20 !");
                        number = 0;

                    }
                    else {
                        erreurLabel.setText("");
                    }
                }
                return getYRadarChart(number, 6);
            }
        };

        point1.centerXProperty().bind(bindingX1);
        point1.centerYProperty().bind(bindingY1);

        point2.centerXProperty().bind(bindingX2);
        point2.centerYProperty().bind(bindingY2);

        point3.centerXProperty().bind(bindingX3);
        point3.centerYProperty().bind(bindingY3);

        point4.centerXProperty().bind(bindingX4);
        point4.centerYProperty().bind(bindingY4);

        point5.centerXProperty().bind(bindingX5);
        point5.centerYProperty().bind(bindingY5);

        point6.centerXProperty().bind(bindingX6);
        point6.centerYProperty().bind(bindingY6);

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
