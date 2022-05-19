module com.oop.projekt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.projekt to javafx.fxml;
    exports com.oop.projekt;
}