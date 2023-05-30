module com.example.tpc9 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tpc9 to javafx.fxml;
    exports com.example.tpc9;
}