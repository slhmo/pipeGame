module application.project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens application.project to javafx.fxml;
    exports application.project;
}