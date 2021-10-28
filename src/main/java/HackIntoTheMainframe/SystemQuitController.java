package HackIntoTheMainframe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class SystemQuitController {

    @FXML
    Label correctAnswerLabel;

    @FXML
    public void click() throws IOException {
        App.setRoot("Connection");
    }

    public void initialize() {
        correctAnswerLabel.setText(String.format("Correct Answer Was : %s %s", GameScreenController.taskOneAnswer,
                GameScreenController.taskTwoAnswer));
    }
}
