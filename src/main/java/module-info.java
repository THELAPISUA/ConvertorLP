module org.lapis_studio.convertorlp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.lapis_studio.convertorlp to javafx.fxml;
    exports org.lapis_studio.convertorlp;
}