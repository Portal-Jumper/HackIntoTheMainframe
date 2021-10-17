package HackIntoTheMainframe;

import java.io.IOException;

public class ConnectionController {

    public void initialize() {
        App.resize1200x600();
        thread1.start();
    }

    Thread thread1 = new Thread(() -> {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            App.setRoot("Hackermans");
        } catch (IOException e) {
            e.printStackTrace();
        }
    });

}
