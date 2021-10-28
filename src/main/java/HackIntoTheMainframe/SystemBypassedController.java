package HackIntoTheMainframe;

import javafx.fxml.FXML;

import java.io.IOException;

public class SystemBypassedController {

    @FXML
    public void click() throws IOException {
        App.setRoot("Connection");
    }

}
