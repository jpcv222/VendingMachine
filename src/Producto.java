/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanc
 */
public class Producto implements Comparable<Producto>{
    String nombre, urlImagen;
    int precio, ubicacion, cantidad, codigo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public Producto(String nombre, String urlImagen, int precio, int ubicacion, int cantidad) {
        this.nombre = nombre;
        this.urlImagen = urlImagen;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.cantidad = cantidad;
    }

    public Producto() {
         this.cantidad = 0;
    }
    
    

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

  
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   @Override
        public int compareTo(Producto o) {
            if (cantidad < o.cantidad) {
                return -1;
            }
            if (cantidad > o.cantidad) {
                return 1;
            }
            return 0;
        }  
    
    
}
