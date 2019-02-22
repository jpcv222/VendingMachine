/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanc
 */
import static java.lang.String.valueOf;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Maquina {

    ArrayList<Venta> arregloVenta;
    Dinero[] arregloDineroCaja;
    ArrayList<Dinero> arregloDineroCambio;
    Producto[][] matrizMaquina;
    int dineroCaja;

    //Valida fecha ingresada
    //Retorna true si es válida la fecha
    public boolean validarFecha(String horaInicial, String horaFinal) {

        if (!horaInicial.equals("") && !horaFinal.equals("")) {
            //Si no están vacíos ambos
            int _minIn, _minFin, _horaIn, _horaFin;

            //horaIn representa a los dos primeros digitos en la hora inicial (HORA)
            //horaFin representa a los dos primeros digitos en la hora final     (HORA)
            //minIn representa a los dos últimos digitos en la hora inical (MINUTOS)
            //minFin representa a los dos +ultimos digitos en la hora final    (MINUTOS)
            try {
                String horaIn = horaInicial.split(":")[0];
                String horaFin = horaFinal.split(":")[0];
                String minIn = horaInicial.split(":")[1];
                String minFin = horaFinal.split(":")[1];

                _minIn = Integer.parseInt(minIn);
                _minFin = Integer.parseInt(minFin);
                _horaIn = Integer.parseInt(horaIn);
                _horaFin = Integer.parseInt(horaFin);

                if (_horaIn == _horaFin) {
                    return _minIn <= _minFin;
                } else {
                    return _horaIn < _horaFin;
                }

            } catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException exp) {

                return false;
            }

        } else {
            return false;
        }

    }

    public String ventasIntervalo(String inicio, String fin) {
        String respuesta = "VENTAS EN INTERVALO INGRESADO \n \n";
        if (validarFecha(inicio, fin)) {
        try{
            int horaIn = Integer.parseInt(inicio.split(":")[0]);
            int horaFin =Integer.parseInt(fin.split(":")[0]);
            int minIn =  Integer.parseInt(inicio.split(":")[1]);
            int minFin = Integer.parseInt(fin.split(":")[1]);
            //Traer ventas entre las horas
            int horaVenta, minVenta;
            for (int i = 0; i < arregloVenta.size(); i++) {
                horaVenta = arregloVenta.get(i).getHora();
                minVenta = arregloVenta.get(i).getMinuto();
                
                if ((horaVenta > horaIn && horaVenta < horaFin) 
                        || (horaVenta == horaIn && horaVenta != horaFin && minVenta >= minIn)
                        || (horaVenta == horaFin && horaVenta != horaFin && minVenta <= minFin)
                        || (horaVenta == horaFin && horaVenta == horaFin && minVenta >= minIn && minVenta<=minFin)) {
                    //Si está entre las horas ingresadas
            
                respuesta +="Producto: "+arregloVenta.get(i).getProductoVenta().getNombre()+ "Fecha venta: "+ arregloVenta.get(i).getFecha()+ 
                                " Ingreso: "+arregloVenta.get(i).getDineroIngresado()
                                + " Cambio: "+ arregloVenta.get(i).getDineroCambio()+ 
                                    " Total neto: "+ arregloVenta.get(i).getTotalNeto()+ "\n";
                
                } else {
                    respuesta = "NO HAY VENTAS EN ESE INTERVALO.\n";
            }
            }
            
        }catch(NullPointerException | NumberFormatException | ArrayIndexOutOfBoundsException exp){
            //Por las buenas prácticas usar try catch
          respuesta = "ERROR EN INTERVALO DE HORAS \n";
        }
        } else {
            respuesta = "ERROR EN INTERVALO DE HORAS \n";
        }
        return respuesta;
    }

    //Recorre el arreglo dinámico de ventas y trae un objeto producto que coincida con el parámetro
    //Además, trae la cantidad de veces que el objeto ha sido vendido, modificando el atributo cantidad
    public Producto getProductoVendido(String nombre) {

        Producto producto = new Producto(), auxiliar;
        int cantidadVendido = 0;
        for (int i = 0; i < arregloVenta.size(); i++) {
            auxiliar = arregloVenta.get(i).getProductoVenta();
            if (auxiliar.getNombre().equals(nombre)) {
                producto = auxiliar;
                cantidadVendido++;
            }
        }

        producto.cantidad = cantidadVendido;

        return producto;
    }

    //Calcula el producto que fue más vendido
    public String productoMasVendido() {

        String respuesta = "";
        Producto obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10;
        try {
            obj1 = getProductoVendido("Pony Malta");
            obj2 = getProductoVendido("CocaCola");
            obj3 = getProductoVendido("Milo");
            obj4 = getProductoVendido("Jugo del valle");
            obj5 = getProductoVendido("Agua");
            obj6 = getProductoVendido("Café");
            obj7 = getProductoVendido("Hit");
            obj8 = getProductoVendido("Colombiana");
            obj9 = getProductoVendido("Poker");
            obj10 = getProductoVendido("Sprite");

            if (obj1.getCantidad() == 0 && obj2.getCantidad() == 0 && obj3.getCantidad() == 0
                    && obj4.getCantidad() == 0 && obj5.getCantidad() == 0 && obj6.getCantidad() == 0
                    && obj7.getCantidad() == 0 && obj8.getCantidad() == 0 && obj9.getCantidad() == 0
                    && obj10.getCantidad() == 0) {
                respuesta = "NO HAY PRODUCTOS VENDIDOS. \n";

            } else {
                Producto[] productos = new Producto[10];
                productos[0] = obj1;
                productos[1] = obj2;
                productos[2] = obj3;
                productos[3] = obj4;
                productos[4] = obj5;
                productos[5] = obj6;
                productos[6] = obj7;
                productos[7] = obj8;
                productos[8] = obj9;
                productos[9] = obj10;

                respuesta += "-----------Producto más vendido.\n";

                Arrays.sort(productos);
                int tamanio = productos.length - 1;

                respuesta += (productos[tamanio].getCantidad() != 0) ? productos[tamanio].getNombre() + ": " + productos[tamanio].getCantidad() + " ventas\n" : "";

            }

        } catch (NullPointerException EXP) {
            System.out.println("Producto no vendido.");
        }

        return respuesta;
    }

    //Calcula la cantidad de dinero por cada producto
    public String dineroPorProducto() {

        String respuesta = "";
        Producto obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10;
        try {
            obj1 = getProductoVendido("Pony Malta");
            obj2 = getProductoVendido("CocaCola");
            obj3 = getProductoVendido("Milo");
            obj4 = getProductoVendido("Jugo del valle");
            obj5 = getProductoVendido("Agua");
            obj6 = getProductoVendido("Café");
            obj7 = getProductoVendido("Hit");
            obj8 = getProductoVendido("Colombiana");
            obj9 = getProductoVendido("Poker");
            obj10 = getProductoVendido("Sprite");

            if (obj1.getCantidad() == 0 && obj2.getCantidad() == 0 && obj3.getCantidad() == 0
                    && obj4.getCantidad() == 0 && obj5.getCantidad() == 0 && obj6.getCantidad() == 0
                    && obj7.getCantidad() == 0 && obj8.getCantidad() == 0 && obj9.getCantidad() == 0
                    && obj10.getCantidad() == 0) {
                respuesta = "NO HAY PRODUCTOS VENDIDOS. \n";

            } else {
                Producto[] productos = new Producto[10];
                productos[0] = obj1;
                productos[1] = obj2;
                productos[2] = obj3;
                productos[3] = obj4;
                productos[4] = obj5;
                productos[5] = obj6;
                productos[6] = obj7;
                productos[7] = obj8;
                productos[8] = obj9;
                productos[9] = obj10;

                respuesta += "-----------Dinero por producto vendido.\n";

                for (int i = 0; i < 10; i++) {

                    respuesta += (productos[i].getCantidad() != 0) ? productos[i].getNombre() + ": " + productos[i].getCantidad() * productos[i].getPrecio() + "\n" : "";
                }

            }

        } catch (NullPointerException EXP) {
            System.out.println("Producto no vendido.");
        }

        return respuesta;
    }

    //Setea a 10 la cantidad del producto que hay en una casilla de la matriz, siempre y cuando se halla acabado.
    public String reabastecerTodo() {
        String respuesta = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                if (!validarStockCasilla(i, j)) {
                    reabastecer(i, j);
                    respuesta += "Se reabasteció: " + matrizMaquina[i][j].getNombre() + " en casilla " + matrizMaquina[i][j].getUbicacion() + "\n";
                }
            }
        }

        return respuesta;
    }

    //Setea a 10 la cantidad del producto que hay en una casilla de la matriz
    public void reabastecer(int fila, int columna) {
        Producto unProducto = matrizMaquina[fila][columna];
        unProducto.cantidad = 10;
        matrizMaquina[fila][columna] = unProducto;
    }

    //Comprueba si en la máquina aún queda el mismo producto en otra casilla
    //Retorna un mensaje vacío si aún quedan
    // Retorna mensaje de rutura de stock si no quedan
    public String ruturaStock(Producto productoElegido) {
        String mensaje = "", nombre = productoElegido.getNombre();
        int cantidad = 0;

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 4; j++) {
                Producto unProducto = matrizMaquina[i][j];
                if (unProducto.getNombre().equals(nombre)) {
                    cantidad += unProducto.getCantidad();
                }
            }

        }

        if (cantidad == 0) {
            mensaje = "\n \n NO HAY MÁS " + nombre + " EN LA MÁQUINA \n \n";
        }

        return mensaje;
    }

    //Comprueba si el dinero en caja es mayor o igual al que debe devolver
    public int getDineroCaja() {
        return dineroCaja;
    }

    //Convierte número de casilla ingresado por el usuario, a fila correspondiente.
    //Ejemplo: getFila(3) retorna 0. 
    //La casilla 3 se encuentra en la fila 0.
    public int getFila(int numeroCasilla) {
        int resultado = -99;

        if (numeroCasilla >= 1 && numeroCasilla <= 4) {
            resultado = 0;
        } else if (numeroCasilla >= 5 && numeroCasilla <= 8) {
            resultado = 1;
        } else if (numeroCasilla >= 9 && numeroCasilla <= 12) {
            resultado = 2;
        } else if (numeroCasilla >= 13 && numeroCasilla <= 16) {
            resultado = 3;
        } else if (numeroCasilla >= 17 && numeroCasilla <= 20) {
            resultado = 4;
        } else if (numeroCasilla >= 21 && numeroCasilla <= 24) {
            resultado = 5;
        } else if (numeroCasilla >= 25 && numeroCasilla <= 28) {
            resultado = 6;
        } else if (numeroCasilla >= 29 && numeroCasilla <= 32) {
            resultado = 7;
        } else if (numeroCasilla >= 33 && numeroCasilla <= 36) {
            resultado = 8;
        } else if (numeroCasilla >= 37 && numeroCasilla <= 40) {
            resultado = 9;
        }

        return resultado;
    }

    //Convierte número de casilla ingresado por el usuario, a columna correspondiente.
    //Ejemplo: getColumna(3) retorna 2. 
    //La casilla 3 se encuentra en la columna 2.
    public int getColumna(int numeroCasilla) {

        int resultado = -99;

        if (numeroCasilla == 1 || numeroCasilla == 5 || numeroCasilla == 9 || numeroCasilla == 13
                || numeroCasilla == 17 || numeroCasilla == 21 || numeroCasilla == 25 || numeroCasilla == 29 || numeroCasilla == 33
                || numeroCasilla == 37) {
            resultado = 0;
        } else if (numeroCasilla == 2 || numeroCasilla == 6 || numeroCasilla == 10 || numeroCasilla == 14
                || numeroCasilla == 18 || numeroCasilla == 22 || numeroCasilla == 26 || numeroCasilla == 30 || numeroCasilla == 34
                || numeroCasilla == 38) {
            resultado = 1;
        } else if (numeroCasilla == 3 || numeroCasilla == 7 || numeroCasilla == 11 || numeroCasilla == 15
                || numeroCasilla == 19 || numeroCasilla == 23 || numeroCasilla == 27 || numeroCasilla == 31 || numeroCasilla == 35
                || numeroCasilla == 39) {
            resultado = 2;
        } else if (numeroCasilla == 4 || numeroCasilla == 8 || numeroCasilla == 12 || numeroCasilla == 16
                || numeroCasilla == 20 || numeroCasilla == 24 || numeroCasilla == 28 || numeroCasilla == 32 || numeroCasilla == 36
                || numeroCasilla == 40) {
            resultado = 3;
        }

        return resultado;
    }

    //Agrega un objeto Producto a una posición de la matriz. 
    //La posición corresponde a la casilla en la que está el producto en la interfaz
    public void agregarProducto(Producto unProducto, int x, int y) {
        matrizMaquina[x][y] = unProducto;
    }

    //Agrega un objeto Dinero a una posición del arreglo
    //El arreglo contiene el dinero en caja por cada tipo de opción de pago en la máquina
    public void agregarMedioPago(Dinero unDinero, int x) {
        arregloDineroCaja[x] = unDinero;
    }

    //Valida que el valor ingresado sea igual o mayor al precio del producto elegido
    public boolean validarIngreso(int ingreso, int precioProducto) {
        return (ingreso >= precioProducto);
    }

    //Añade al Array list de ventas, una venta realizada
    public void agregarVenta(int dineroIngresado, int cambio, Producto productoVendido) {

        try {
            int totalNeto = dineroIngresado - cambio;
            Date fechaVenta = new Date();
            String fecha = String.valueOf(fechaVenta);
            int hora = fechaVenta.getHours(), minuto = fechaVenta.getMinutes();
            Venta nuevaVenta = new Venta(fecha, dineroIngresado, cambio, totalNeto, productoVendido, hora, minuto);
            System.out.println(totalNeto + " " + dineroIngresado + " " + cambio + " " + fecha + " " + productoVendido.getNombre() + " " + hora + " " + minuto);
            arregloVenta.add(nuevaVenta);

        } catch (NullPointerException excp) {
            System.out.println("Fallo en conversión de fecha.");
        }

    }

    //Modifica el dinero en caja
    public void ingresarDinero(int dineroIngresado) {
        dineroCaja += dineroIngresado;
    }

    //Realiza proceso de venta de un producto del stock
    //Retorna un string indicando el resultado de la operación
    public String vender(Producto productoElegido, int fila, int columna, int total, int cambio) {

        Producto productoStock = matrizMaquina[fila][columna];
        int cantidadStock;
        String retorno;

        //Validar que el producto esté en la casilla seleccionada
        if (validarStockCasilla(fila, columna)) {
            if (productoStock.getNombre().equals(productoElegido.getNombre())) {
                cantidadStock = productoStock.getCantidad();
                productoStock.setCantidad(cantidadStock - 1);

                retorno = "Producto " + productoElegido.getNombre() + " vendido con éxito \n";
                retorno += "Se regresa cambio de: " + cambio + "\n";
                ingresarDinero(productoElegido.getPrecio());
                agregarVenta(total, cambio, productoElegido);
            } else {
                retorno = "Producto " + productoElegido.getNombre() + " NO vendido con éxito \n";

            }
        } else {
            retorno = "Producto " + productoElegido.getNombre() + " AGOTADO en la casilla \n";
        }

        //Validar que el producto recibido sea el mismo que está en el stock de la máquina en la posición enviada.
        return retorno;
    }

    //Valida la existencia de un producto en una columna
    //Retorna true si aún hay producto en esa casilla
    //Retorna false si no hay pproducto en esa casilla
    public boolean validarStockCasilla(int fila, int columna) {
        Producto productoStock = matrizMaquina[fila][columna];

        return (!(productoStock.getCantidad() == 0));

    }

    //Valida que la máquina tenga cambio por denminación
    public boolean validarCambio(int debeDevolver) {
        //Copia del arreglo del dinero en caja para posible cambio
        arregloDineroCambio.clear();

        int caja = getDineroCaja();

        if (caja >= debeDevolver) {
            //Si hay algo en caja, mire si puede devolver
            return true;
        } else {
            return debeDevolver == 0;

        }

    }

    public ArrayList<Venta> getArregloVenta() {
        return arregloVenta;
    }

    public void setArregloVenta(ArrayList<Venta> arregloVenta) {
        this.arregloVenta = arregloVenta;
    }

    public Dinero[] getArregloDineroCaja() {
        return arregloDineroCaja;
    }

    public void setArregloDineroCaja(Dinero[] arregloDineroCaja) {
        this.arregloDineroCaja = arregloDineroCaja;
    }

    public Producto[][] getMatrizMaquina() {
        return matrizMaquina;
    }

    public void setMatrizMaquina(Producto[][] matrizMaquina) {
        this.matrizMaquina = matrizMaquina;
    }

    public Maquina(ArrayList<Venta> arregloVenta, Dinero[] arregloDineroCaja, Producto[][] matrizMaquina) {
        this.arregloVenta = arregloVenta;
        this.arregloDineroCaja = arregloDineroCaja;
        this.matrizMaquina = matrizMaquina;
    }

    public Maquina(Dinero[] arregloDineroCaja, Producto[][] matrizMaquina) {
        this.matrizMaquina = matrizMaquina;
        this.arregloDineroCaja = arregloDineroCaja;
        this.arregloVenta = new ArrayList<>();
        this.arregloDineroCambio = new ArrayList<>();
        this.dineroCaja = 0;
    }

}
