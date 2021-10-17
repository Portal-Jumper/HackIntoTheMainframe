package HackIntoTheMainframe;

import java.util.Random;

public class GameInfo {

    static Random random = new Random();

    public static int firstPaneNumber = 0;
    public static int secondPaneNumber = 0;
    public static int thirdPaneNumber = 0;
    public static int fourthPaneNumber = 0;


    public static void randomizePaneNumbers() {
        firstPaneNumber = 0;
        secondPaneNumber = 0;
        thirdPaneNumber = 0;
        fourthPaneNumber = 0;

        firstPaneNumber = random.nextInt(4) + 1;

        do {
            secondPaneNumber = random.nextInt(4) + 1;
        } while (secondPaneNumber == firstPaneNumber);

        do {
            thirdPaneNumber = random.nextInt(4) + 1;
        } while (thirdPaneNumber == firstPaneNumber || thirdPaneNumber == secondPaneNumber);

        do {
            fourthPaneNumber = random.nextInt(4) + 1;
        } while (fourthPaneNumber == firstPaneNumber || fourthPaneNumber == secondPaneNumber ||
                fourthPaneNumber == thirdPaneNumber);
    }

}
