module java_fx {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires de.jensd.fx.glyphs.commons;
    requires de.jensd.fx.glyphs.fontawesome;
    requires transitive javafx.graphics;

    exports java_fx;
    exports java_fx.entities;



}
