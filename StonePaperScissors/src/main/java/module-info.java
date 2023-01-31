module com.play.stonepaperscissors {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.play.stonepaperscissors to javafx.fxml;
    exports com.play.stonepaperscissors;
    opens com.play.stonepaperscissors.controller to javafx.fxml;
    exports com.play.stonepaperscissors.controller;
}