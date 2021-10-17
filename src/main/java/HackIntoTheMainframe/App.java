package HackIntoTheMainframe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        scene = new Scene(loadFXML("Start"));
        Image image = new Image("HackIntoTheMainframe/Assets/spy-icon.png");
        stage.setResizable(false);
        stage.setTitle("Hack Into The Mainframe");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void resize1200x600(){
        stage.setWidth(1200);
        stage.setHeight(600);
    }

    static void resize800x600(){
        stage.setWidth(800);
        stage.setHeight(600);
    }

    public static void main(String[] args) {
        launch();
    }

}