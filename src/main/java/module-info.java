module HacIntoTheMainframe {
    requires javafx.controls;
    requires javafx.fxml;

    opens HacIntoTheMainframe to javafx.fxml;
    exports HacIntoTheMainframe;
}