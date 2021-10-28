package HackIntoTheMainframe;

import javafx.fxml.FXML;

import java.io.IOException;

public class StartController {

    public void initialize() {
        App.resize800x550();
    }

    @FXML
    private void switchToConnection() throws IOException {
        App.setRoot("Connection");
    }

    @FXML
    private void switchToTutorial() throws IOException {
        App.setRoot("Tutorial");
    }
}
