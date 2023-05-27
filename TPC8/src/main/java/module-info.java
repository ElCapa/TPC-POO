module com.example.tpc8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tpc8 to javafx.fxml;
    exports com.example.tpc8;
}