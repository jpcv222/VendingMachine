/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanc
 */

public class Venta {
    String fecha;
    int dineroIngresado, dineroCambio, totalNeto, hora, minuto;

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
    Producto productoVenta;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(int totalNeto) {
        this.totalNeto = totalNeto;
    }

    public int getDineroIngresado() {
        return dineroIngresado;
    }

    public void setDineroIngresado(int dineroIngresado) {
        this.dineroIngresado = dineroIngresado;
    }

    public int getDineroCambio() {
        return dineroCambio;
    }

    public void setDineroCambio(int dineroCambio) {
        this.dineroCambio = dineroCambio;
    }

    public Producto getProductoVenta() {
        return productoVenta;
    }

    public void setProductoVenta(Producto productoVenta) {
        this.productoVenta = productoVenta;
    }

    public Venta(String fecha, int dineroIngresado, int dineroCambio, int totalNeto, Producto productoVenta, int hora, int minuto) {
        this.fecha = fecha;
        this.dineroIngresado = dineroIngresado;
        this.dineroCambio = dineroCambio;
        this.totalNeto   = totalNeto;
        this.productoVenta = productoVenta;
        this.hora   = hora;
        this.minuto = minuto;
    }
    
    
    
}
