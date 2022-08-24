module com.example.timerpc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.timerpc to javafx.fxml;
    exports com.example.timerpc;
}