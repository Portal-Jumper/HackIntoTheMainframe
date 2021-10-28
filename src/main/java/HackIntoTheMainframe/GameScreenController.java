package HackIntoTheMainframe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameScreenController {

    Random random = new Random();

    @FXML
    AnchorPane scene;

    @FXML
    Rectangle rectangle1, rectangle2, rectangle3, rectangle4, backRectangle1, backRectangle2, backRectangle3,
            backRectangle4;
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

//    List contains in order: backgroundColor,shape,shapeColor,numberColor,colorText,shapeText,textBackgroundColor

    public static ArrayList<String> pane1List;
    public static ArrayList<String> pane2List;
    public static ArrayList<String> pane3List;
    public static ArrayList<String> pane4List;

    private String task = "Enter ";
    public static String taskOneAnswer = "";
    public static String taskTwoAnswer = "";

    private int taskOneNumber = random.nextInt(4) + 1;
    private int taskTwoNumber = random.nextInt(4) + 1;

    private boolean andAdded = false;

    public void initialize() {

        while (taskOneNumber == taskTwoNumber)
            taskTwoNumber = random.nextInt(4) + 1;

        number1.setText(String.valueOf(random.nextInt(10)));
        number2.setText(String.valueOf(random.nextInt(10)));
        number3.setText(String.valueOf(random.nextInt(10)));
        number4.setText(String.valueOf(random.nextInt(10)));

        pane1List = randomizePane(backRectangle1, rectangle1, circle1, triangle1, number1, shapeText1, colorText1);
        pane2List = randomizePane(backRectangle2, rectangle2, circle2, triangle2, number2, shapeText2, colorText2);
        pane3List = randomizePane(backRectangle3, rectangle3, circle3, triangle3, number3, shapeText3, colorText3);
        pane4List = randomizePane(backRectangle4, rectangle4, circle4, triangle4, number4, shapeText4, colorText4);

        scene.setOnKeyPressed(e ->{
            if(e.getCode() == KeyCode.ENTER){
                if(answerTextField.getText().equals(taskOneAnswer + " " + taskTwoAnswer)) {
                    try {
                        App.setRoot("SystemBypassed");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else {
                    try {
                        App.setRoot("SystemQuit");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        randomtask(taskOneNumber);
        randomtask(taskTwoNumber);

        taskLabel.setText(task);

        System.out.println(taskOneAnswer);
        System.out.println(taskTwoAnswer);
    }


    private ArrayList randomizePane(Rectangle backRectangle, Rectangle rectangle, Circle circle, Polygon triangle,
                                    Label number,
                                    Label shapeText, Label colorText) {

        ArrayList<String> list = new ArrayList<>(Arrays.asList("","","","","","",""));

        int randomInt1 = random.nextInt(3);

        int shapeColor = random.nextInt(8);
        int backgroundColor;
        int numberColor;
        int textBackgroundColor;

        do {
            backgroundColor = random.nextInt(8);
        } while (backgroundColor == shapeColor);

        do {
            numberColor = random.nextInt(8);
        } while (numberColor == shapeColor || numberColor == backgroundColor);

        do {
            textBackgroundColor = random.nextInt(8);
        } while (textBackgroundColor == numberColor || textBackgroundColor == backgroundColor ||
                textBackgroundColor == shapeColor);

        rectangle.setOpacity(0);
        circle.setOpacity(0);
        triangle.setOpacity(0);


        if (randomInt1 == 0) {
            rectangle.setOpacity(100);
            rectangle.setFill(randomColor(shapeColor));
            shapeText.setText("circle");
            list.set(1,"rectangle");
            list.set(5,"circle");
        }
        if (randomInt1 == 1) {
            circle.setOpacity(100);
            circle.setFill(randomColor(shapeColor));
            shapeText.setText("triangle");
            list.set(1,"circle");
            list.set(5,"triangle");
        }
        if (randomInt1 == 2) {
            triangle.setOpacity(100);
            triangle.setFill(randomColor(shapeColor));
            shapeText.setText("rectangle");
            list.set(1,"triangle");
            list.set(5,"rectangle");
        }

        backRectangle.setFill(randomColor(backgroundColor));
        number.setTextFill(randomColor(numberColor));
        shapeText.setTextFill(randomColor(textBackgroundColor));
        colorText.setTextFill(randomColor(textBackgroundColor));

        list.set(0,randomColorString(backgroundColor));
        list.set(2,randomColorString(shapeColor));
        list.set(3,randomColorString(numberColor));
        int randomColorText = random.nextInt(8);
        colorText.setText(randomColorString(randomColorText));
        list.set(4,randomColorString(randomColorText));
        list.set(6,randomColorString(textBackgroundColor));

        return list;
    }

    private Color randomColor(int random) {
        if (random == 0)
            return Color.BLUE;
        if (random == 1)
            return Color.RED;
        if (random == 2)
            return Color.GREEN;
        if (random == 3)
            return Color.BLACK;
        if (random == 4)
            return Color.WHITE;
        if (random == 5)
            return Color.PURPLE;
        if (random == 6)
            return Color.YELLOW;
        if (random == 7)
            return Color.ORANGE;
        return null;
    }

    private String randomColorString(int random) {
        if (random == 0)
            return "blue";
        if (random == 1)
            return "red";
        if (random == 2)
            return "green";
        if (random == 3)
            return "black";
        if (random == 4)
            return "white";
        if (random == 5)
            return "purple";
        if (random == 6)
            return "yellow";
        if (random == 7)
            return "orange";
        return null;
    }

    private void randomtask(int number) {
        int randomInt = random.nextInt(7);
        if (randomInt == 0) {
            task = task.concat("Background Color " + "(" + number + ") ");
            if(!andAdded)
                taskOneAnswer = checkAnswer(number,0);
            else
                taskTwoAnswer = checkAnswer(number,0);
        }
        if (randomInt == 1) {
            task = task.concat("Shape " + "(" + number + ") ");
            if(!andAdded)
                taskOneAnswer = checkAnswer(number,1);
            else
                taskTwoAnswer = checkAnswer(number,1);
        }
        if (randomInt == 2) {
            task = task.concat("Shape Color " + "(" + number + ") ");
            if(!andAdded)
                taskOneAnswer = checkAnswer(number,2);
            else
                taskTwoAnswer = checkAnswer(number,2);
        }
        if (randomInt == 3) {
            task = task.concat("Number Color " + "(" + number + ") ");
            if(!andAdded)
                taskOneAnswer = checkAnswer(number,3);
            else
                taskTwoAnswer = checkAnswer(number,3);
        }
        if (randomInt == 4) {
            task = task.concat("Color Text " + "(" + number + ") ");
            if(!andAdded)
                taskOneAnswer = checkAnswer(number,4);
            else
                taskTwoAnswer = checkAnswer(number,4);
        }
        if (randomInt == 5) {
            task = task.concat("Shape Text " + "(" + number + ") ");
            if(!andAdded)
                taskOneAnswer = checkAnswer(number,5);
            else
                taskTwoAnswer = checkAnswer(number,5);
        }
        if (randomInt == 6) {
            task = task.concat("Text Background Color " + "(" + number + ") ");
            if(!andAdded)
                taskOneAnswer = checkAnswer(number,6);
            else
                taskTwoAnswer = checkAnswer(number,6);
        }
        if(!andAdded) {
            task = task.concat("And ");
            andAdded = true;
        }
    }

    private String checkAnswer(int listNumber, int taskNumber) {
        if(listNumber == 1){
            if(GameInfo.firstPaneNumber == 1)
                return pane1List.get(taskNumber);
            if(GameInfo.firstPaneNumber == 2)
                return pane2List.get(taskNumber);
            if(GameInfo.firstPaneNumber == 3)
                return pane3List.get(taskNumber);
            if(GameInfo.firstPaneNumber == 4)
                return pane4List.get(taskNumber);
        }
        if(listNumber == 2){
            if(GameInfo.secondPaneNumber == 1)
                return pane1List.get(taskNumber);
            if(GameInfo.secondPaneNumber == 2)
                return pane2List.get(taskNumber);
            if(GameInfo.secondPaneNumber == 3)
                return pane3List.get(taskNumber);
            if(GameInfo.secondPaneNumber == 4)
                return pane4List.get(taskNumber);
        }
        if(listNumber == 3){
            if(GameInfo.thirdPaneNumber == 1)
                return pane1List.get(taskNumber);
            if(GameInfo.thirdPaneNumber == 2)
                return pane2List.get(taskNumber);
            if(GameInfo.thirdPaneNumber == 3)
                return pane3List.get(taskNumber);
            if(GameInfo.thirdPaneNumber == 4)
                return pane4List.get(taskNumber);
        }
        if(listNumber == 4){
            if(GameInfo.fourthPaneNumber == 1)
                return pane1List.get(taskNumber);
            if(GameInfo.fourthPaneNumber == 2)
                return pane2List.get(taskNumber);
            if(GameInfo.fourthPaneNumber == 3)
                return pane3List.get(taskNumber);
            if(GameInfo.fourthPaneNumber == 4)
                return pane4List.get(taskNumber);
        }
        return null;
    }
}
