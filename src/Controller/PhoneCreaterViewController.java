package Controller;

import Model.DBConnect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PhoneCreaterViewController implements Initializable {
    @FXML
    private ChoiceBox<String> MakeChoiceBox;

    @FXML
    private TextField ModelTextField;

    @FXML
    private ChoiceBox<String> OSChoiceBox;

    @FXML
    private TextField ScreenSizeTextField;

    @FXML
    private Slider MemorySlider;

    @FXML
    private Label MemoryLabel;

    @FXML
    private TextField FrontCameraTextField;

    @FXML
    private TextField RearCameraTextField;

    @FXML
    private TextField PriceTextField;

    @FXML
    private ImageView ImageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Preload the choice box with valid manufacturers
        try {
            MakeChoiceBox.getItems().addAll(DBConnect.getPhoneManufactures());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MakeChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> OSChoiceBox.setValue(newValue)
                //OSChoiceBox.setValue(DBConnect.getPhoneManufactures(newValue));
        );
    }
}
