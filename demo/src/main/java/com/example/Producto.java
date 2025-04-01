package com.example;
import java.time.*;

public class Producto {
    private int ID; 
    public int Cantidad;
    public static int Idreferencia = 0;
    private double precio;
    private String nombre; 
    private LocalDate fechaAgregado; 

    // creamos los dos contructores 
    public Producto(){
       this.fechaAgregado = LocalDate.now();
    }
    public Producto(double precio,String nombre,int Cantidad){
        if (Cantidad <= 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }

     this.precio = precio;
     this.nombre = nombre;
     this.ID = ++Producto.Idreferencia;
     this.fechaAgregado = LocalDate.now();
     this.Cantidad = Cantidad;
     
    }

    // creamos los getters y seters 
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public double getPrecio(){
        return this.precio;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getID(){
        return this.ID;
    }
    public void setfechaAgregado(LocalDate fechDate){
         this.fechaAgregado = fechDate;
    }
    public LocalDate getlLocalDate(){
        return this.fechaAgregado;
    }
    public void setCantidad(int Cantidad){
        if (Cantidad > 0){
            this.Cantidad = Cantidad;
        }
    }
    public int getCantidad(){
        return this.Cantidad;
    }


    // creamos el toString de nuestra clase 
    @Override
    public String toString(){
        return "Nombre producto:\t " + getNombre() 
        + "\nCantidad de producto:\t " + getCantidad() 
        + " \nPrecio del producto:\t " + getPrecio() 
        + "\nFecha de agregacion:\t " + getlLocalDate() 
        + "\nID del producto:\t " + getID();
    }
    
}
