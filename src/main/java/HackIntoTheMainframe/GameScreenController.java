package HackIntoTheMainframe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class GameScreenController {

    Random random = new Random();

    @FXML
    Rectangle rectangle1,rectangle2,rectangle3,rectangle4,backRectangle1,backRectangle2,backRectangle3,backRectangle4;
    @FXML
    Circle circle1, circle2, circle3, circle4;
    @FXML
    Polygon triangle1, triangle2, triangle3, triangle4;
    @FXML
    Label number1, number2, number3, number4, shapeText1, shapeText2, shapeText3, shapeText4, colorText1, colorText2,
            colorText3,
            colorText4, taskLabel;
    @FXML
    TextField answerTextField;

    public void initialize() {
        randomizePane(backRectangle1,rectangle1,circle1,triangle1,number1,shapeText1,colorText1);
        randomizePane(backRectangle2,rectangle2,circle2,triangle2,number2,shapeText2,colorText2);
        randomizePane(backRectangle3,rectangle3,circle3,triangle3,number3,shapeText3,colorText3);
        randomizePane(backRectangle4,rectangle4,circle4,triangle4,number4,shapeText4,colorText4);
    }


    private void randomizePane(Rectangle backRectangle, Rectangle rectangle, Circle circle, Polygon triangle,
                               Label number,
                               Label shapeText, Label colorText) {
        int randomInt1 = random.nextInt(3);

        int randomColor1 = random.nextInt(8);
        int randomColor2;
        int randomColor3;
        int randomColor4;

        do {
            randomColor2 = random.nextInt(8);
        } while(randomColor2 == randomColor1);

        do {
            randomColor3 = random.nextInt(8);
        } while(randomColor3 == randomColor1 || randomColor3 == randomColor2);

        do {
            randomColor4 = random.nextInt(8);
        } while(randomColor4 == randomColor3 || randomColor4 == randomColor2 || randomColor4 == randomColor1);

        rectangle.setOpacity(0);
        circle.setOpacity(0);
        triangle.setOpacity(0);

        if(randomInt1 == 0){
            rectangle.setOpacity(100);
            rectangle.setFill(randomColor(randomColor1));
            System.out.println("rectangle");
        }
        if(randomInt1 == 1){
            circle.setOpacity(100);
            circle.setFill(randomColor(randomColor1));
            System.out.println("circle");
        }
        if(randomInt1 == 2){
            triangle.setOpacity(100);
            triangle.setFill(randomColor(randomColor1));
            System.out.println("triangle");
        }

        backRectangle.setFill(randomColor(randomColor2));
        number.setTextFill(randomColor(randomColor3));
        shapeText.setTextFill(randomColor(randomColor4));
        colorText.setTextFill(randomColor(randomColor4));
    }

    private Color randomColor(int random) {
        if(random == 0){
            return Color.BLUE;
        }
        if(random == 1){
            return Color.RED;
        }
        if(random == 2){
            return Color.GREEN;
        }
        if(random == 3){
            return Color.BLACK;
        }
        if(random == 4){
            return Color.WHITE;
        }
        if(random == 5){
            return Color.PURPLE;
        }
        if(random == 6){
            return Color.YELLOW;
        }
        if(random == 7){
            return Color.ORANGE;
        }
        return null;
    }
}
