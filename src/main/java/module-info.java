module ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario to javafx.fxml;
    exports ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;
}