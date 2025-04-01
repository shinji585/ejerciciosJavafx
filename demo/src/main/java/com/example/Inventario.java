package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventario {
    static Scanner s = new Scanner(System.in);
    private List<Producto> productos = new ArrayList<>();

    // Constructor vacío
    public Inventario() {
    }

    // Método para agregar productos
    public void agregarProducto() {
        System.out.print("Ingrese la cantidad de productos que va a agregar: ");
        while (!s.hasNextInt()) {
            System.out.println("La entrada tiene que ser un número entero.\nIngrese un número por favor: ");
            s.next();
        }
        int cantidad = s.nextInt();
        s.nextLine(); // Consumir el salto de línea

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingresando producto #" + (i + 1));

            System.out.print("Nombre del producto: ");
            String nombre = s.nextLine();

            System.out.print("Precio del producto: ");
            while (!s.hasNextDouble()) {
                System.out.println("Entrada inválida. Ingrese un número decimal:");
                s.next();
            }
            double precio = s.nextDouble();

            System.out.print("Cantidad del producto: ");
            while (!s.hasNextInt()) {
                System.out.println("Entrada inválida. Ingrese un número entero:");
                s.next();
            }
            int cantidadProducto = s.nextInt();
            s.nextLine(); // Consumir el salto de línea

            Producto nuevoProducto = new Producto(precio, nombre, cantidadProducto);
            productos.add(nuevoProducto);

            System.out.println("Producto agregado con éxito.\n");
        }
    }

    // Método para eliminar productos por ID
    public void eliminarProductos(List<Integer> ids) {
        productos.removeIf(producto -> ids.contains(producto.getID()));
    }

    // Listar todos los productos
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    // Actualizar un producto por ID
    public boolean actualizarProducto(int id, Producto nuevoProducto) {
        if (nuevoProducto == null) {
            return false;
        }

        for (Producto producto : productos) {
            if (producto.getID() == id) {
                producto.setNombre(nuevoProducto.getNombre());
                producto.setPrecio(nuevoProducto.getPrecio());
                producto.setCantidad(nuevoProducto.getCantidad());
                producto.setfechaAgregado(nuevoProducto.getlLocalDate());
                return true;
            }
        }
        return false;
    }

    // Buscar un producto por nombre
    public Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }


}
