module com.proyectopoo.proyecto_poo_g10_p02 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.proyectopoo.proyecto_poo_g10_p02 to javafx.fxml;
    exports com.proyectopoo.proyecto_poo_g10_p02;
}