/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanc
 */
public class Dinero {
    String tipo, urlImagen;
    int denominacion, cantidad;

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDenominacion() {
        return denominacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDenominacion(int denominacion) {
        this.denominacion = denominacion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Dinero(String tipo, String urlImagen, int denominacion, int cantidad) {
        this.tipo = tipo;
        this.urlImagen = urlImagen;
        this.denominacion = denominacion;
        this.cantidad = cantidad;
    }
    
    
    
}
