import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

        public void start(Stage primaryStage) throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/converter.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
            primaryStage.setTitle("Conversion Base64 to File");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    public static void main(String[] args) {
        launch(args);
    }
}
