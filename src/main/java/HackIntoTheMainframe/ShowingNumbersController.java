package HackIntoTheMainframe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class ShowingNumbersController {

    @FXML
    Label numberShowOne,numberShowTwo,numberShowThree,numberShowFour;

    public void initialize() {
        GameInfo.randomizePaneNumbers();
        numberShowOne.setText(String.valueOf(GameInfo.firstPaneNumber));
        numberShowTwo.setText(String.valueOf(GameInfo.secondPaneNumber));
        numberShowThree.setText(String.valueOf(GameInfo.thirdPaneNumber));
        numberShowFour.setText(String.valueOf(GameInfo.fourthPaneNumber));
        thread1.start();
    }

    Thread thread1 = new Thread(() -> {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            App.setRoot("GameScreen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    });

}
