package HackIntoTheMainframe;

import java.io.IOException;

public class AccessFlaggedController {

    public void initialize() {
        thread1.start();
    }

    Thread thread1 = new Thread(() -> {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            App.setRoot("ShowingNumbers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    });

}
