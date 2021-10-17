package HackIntoTheMainframe;

import javafx.fxml.FXML;

import java.io.IOException;

public class TutorialController {

    public void initialize() {
        App.resize1200x600();
    }

    @FXML
    private void goBack() throws IOException {
        App.setRoot("Start");
    }

}
