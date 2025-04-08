module com.example._20250408lesson {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example._20250408lesson to javafx.fxml;
    exports com.example._20250408lesson;
    exports com.example._20250408lesson.objects;
}