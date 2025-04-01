module demo {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example;  // NO "com.example.Producto", ya que "Producto" es una clase, no un paquete.
}
