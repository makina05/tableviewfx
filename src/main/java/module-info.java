open module scenebuilder {
  requires java.sql;
  requires javafx.controls;
  requires javafx.graphics;
  requires javafx.fxml;

  requires de.jensd.fx.fontawesomefx.fontawesome;
    requires java.desktop;
    //requires  de.jensd.fx.fontawesomefx.commons;
  exports ehu.isad;

}
