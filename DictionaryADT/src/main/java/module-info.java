module com.example.dictionaryadt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dictionaryadt to javafx.fxml;
    exports com.hash.dictionaryadt;
}