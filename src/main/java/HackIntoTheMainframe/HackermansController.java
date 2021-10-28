package HackIntoTheMainframe;

import java.io.IOException;

public class HackermansController {

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
            App.setRoot("AccessFlagged");
        } catch (IOException e) {
            e.printStackTrace();
        }
    });

}
