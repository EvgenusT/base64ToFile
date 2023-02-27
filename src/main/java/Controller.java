import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

public class Controller {
    @FXML
    public TextArea base64;
    @FXML
    private TextField textfield;
    String xlsx = "xlsx";
    String pdf = "pdf";
    ObservableList<String> localizationList = FXCollections.observableArrayList(pdf, xlsx);
    @FXML
    public ChoiceBox<String> idSwitch;

    public static final String C_CONVERSION = "C:/Conversion/";

    @FXML
    public void initialize() {
        idSwitch.setValue(pdf);
        idSwitch.setItems(localizationList);
    }

    @FXML
    public void pressButtonConversion() {
        String nameFile = textfield.getText();
        String value = idSwitch.getValue();
        String base64Text = base64.getText();
        try {
            extractBase64DecodePdf(base64Text, nameFile, value);
            this.textfield.clear();
            this.base64.clear();
        } catch (Exception e) {
            System.out.println("что то пошло не так!");
        }
    }

    public static void extractBase64DecodePdf(String base64Text, String nameFile, String value) {
        File file = new File(C_CONVERSION + nameFile + "." + value);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] decoder = Base64.getDecoder().decode(base64Text);
            fos.write(decoder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

