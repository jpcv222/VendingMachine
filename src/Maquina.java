/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanc
 */
import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class Maquina {

    ArrayList<Venta> arregloVenta;
    Dinero[] arregloDineroCaja;
    ArrayList<Dinero> arregloDineroCambio;
    Producto[][] matrizMaquina;
    
     //Recorre el arreglo dinámico de ventas y trae un objto producto que coincida con el parámetro
    //Además, trae la cantidad de veces que el objeto ha sido vendido, modificando el atributo cantidad
    public Producto getProductoVendido(String nombre){
        
    Producto producto = new Producto(), auxiliar;
    int cantidadVendido = 0;
    for(int i = 0; i < arregloVenta.size(); i++){
        auxiliar = arregloVenta.get(i).getProductoVenta();
    if(auxiliar.getNombre().equals(nombre)){
        producto = auxiliar;
        cantidadVendido++;
    }
    }
    
    producto.cantidad = cantidadVendido;
    
    return producto;
    }
    
    
    //Calcula la cantidad de dinero por cada producto
    public String dineroPorProducto(){
        
    String respuesta = "";
    Producto obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10;
    try{
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
    
    if(obj1.getCantidad() == 0 && obj2.getCantidad() == 0 && obj3.getCantidad() == 0
            && obj4.getCantidad() == 0 && obj5.getCantidad() == 0 && obj6.getCantidad() == 0
            && obj7.getCantidad() == 0 && obj8.getCantidad() == 0 && obj9.getCantidad() == 0
            && obj10.getCantidad() == 0){
        respuesta = "NO HAY PRODUCTOS VENDIDOS. \n";
    
    }else{
    respuesta += (obj1.getCantidad()!=0)? obj1.getNombre()+ ": "+obj1.getCantidad()*obj1.getPrecio()+"\n":"";
    respuesta += (obj2.getCantidad()!=0)? obj2.getNombre()+ ": "+obj2.getCantidad()*obj2.getPrecio()+"\n":"";
    respuesta += (obj3.getCantidad()!=0)?obj3.getNombre()+ ": "+obj3.getCantidad()*obj3.getPrecio()+"\n":"";
    respuesta += (obj4.getCantidad()!=0)?obj4.getNombre()+ ": "+obj4.getCantidad()*obj4.getPrecio()+"\n":"";
    respuesta += (obj5.getCantidad()!=0)? obj5.getNombre()+ ": "+obj5.getCantidad()*obj5.getPrecio()+"\n":"";
    respuesta += (obj6.getCantidad()!=0)? obj6.getNombre()+ ": "+obj6.getCantidad()*obj6.getPrecio()+"\n":"";
    respuesta += (obj7.getCantidad()!=0)? obj7.getNombre()+ ": "+obj7.getCantidad()*obj7.getPrecio()+"\n":"";
    respuesta += (obj8.getCantidad()!=0)?obj8.getNombre()+ ": "+obj8.getCantidad()*obj8.getPrecio()+"\n":"";
    respuesta += (obj9.getCantidad()!=0)? obj9.getNombre()+ ": "+obj9.getCantidad()*obj9.getPrecio()+"\n":"";
    respuesta += (obj10.getCantidad()!=0)? obj10.getNombre()+ ": "+obj10.getCantidad()*obj10.getPrecio()+"\n":"";
    }
    
    }catch(NullPointerException EXP){
        System.out.println("Producto no vendido.");
    }
    
    return respuesta;
    }
    
   
    //Setea a 10 la cantidad del producto que hay en una casilla de la matriz, siempre y cuando se halla acabado.
    public String reabastecerTodo(){
        String respuesta= "";
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 4; j++   ){
            if(!validarStockCasilla(i,j)){
                reabastecer(i, j);
                respuesta += "Se reabasteció: "+ matrizMaquina[i][j].getNombre()+ " en casilla "+ matrizMaquina[i][j].getUbicacion()+"\n";
            }
            }
    }
        
        return respuesta;
    }
    
    //Setea a 10 la cantidad del producto que hay en una casilla de la matriz
    public void reabastecer(int fila,int columna){
    Producto unProducto= matrizMaquina[fila][columna];
    unProducto.cantidad = 10;
    matrizMaquina[fila][columna]  =   unProducto;
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
        int total1, total2, total3, total4, total5, total6, total7, total8;

        total1 = arregloDineroCaja[0].getCantidad() * arregloDineroCaja[0].getDenominacion();
        total2 = arregloDineroCaja[1].getCantidad() * arregloDineroCaja[1].getDenominacion();
        total3 = arregloDineroCaja[2].getCantidad() * arregloDineroCaja[2].getDenominacion();
        total4 = arregloDineroCaja[3].getCantidad() * arregloDineroCaja[3].getDenominacion();
        total5 = arregloDineroCaja[4].getCantidad() * arregloDineroCaja[4].getDenominacion();
        total6 = arregloDineroCaja[5].getCantidad() * arregloDineroCaja[5].getDenominacion();
        total7 = arregloDineroCaja[6].getCantidad() * arregloDineroCaja[6].getDenominacion();
        total8 = arregloDineroCaja[7].getCantidad() * arregloDineroCaja[7].getDenominacion();

        return total1 + total2 + total3 + total4 + total5 + total6 + total7 + total8;

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
    public void agregarDinero(Dinero unDinero, int x) {
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
            System.out.println(totalNeto + " " + dineroIngresado + " " + cambio + " " + fecha + " " + productoVendido.getNombre()+ " " + hora+ " " + minuto);
            arregloVenta.add(nuevaVenta);

            //calcularCambio(cambio);  
        } catch (NullPointerException excp) {
            System.out.println("Fallo en conversión de fecha.");
        }

    }

    //Modifica el arreglo interno de la máquina con lo que han pagado los clientes
    public void ingresarDinero(int[] dineroIngresado) {

        Dinero unDenominacion;

        for (int i = 0; i < 8; i++) {

            unDenominacion = arregloDineroCaja[i];
            unDenominacion.setCantidad(unDenominacion.getCantidad() + dineroIngresado[i]);
            arregloDineroCaja[i] = unDenominacion;
            System.out.println(arregloDineroCaja[i].getCantidad());
        }

    }

    //Realiza proceso de venta de un producto del stock
    //Retorna un string indicando el resultado de la operación
    public String vender(Producto productoElegido, int fila, int columna) {

        Producto productoStock = matrizMaquina[fila][columna];
        int cantidadStock;
        String retorno;

        //Validar que el producto esté en la casilla seleccionada
        if (validarStockCasilla(fila, columna)) {
            if (productoStock.getNombre().equals(productoElegido.getNombre())) {
                cantidadStock = productoStock.getCantidad();
                productoStock.setCantidad(cantidadStock - 1);

                retorno = "Producto " + productoElegido.getNombre() + " vendido con éxito \n \n";
            } else {
                retorno = "Producto " + productoElegido.getNombre() + " NO vendido con éxito \n \n";

            }
        } else {
            retorno = "Producto " + productoElegido.getNombre() + " AGOTADO en la casilla \n \n";
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
        Dinero[] dinero = arregloDineroCaja;
        int totalCambio = 0, auxiliar = -1;
        int debeDevolverFinal = debeDevolver;
        int caja = getDineroCaja();

        if (caja >= debeDevolver) {
            //Si hay algo en caja, mire si puede devolver
            while (debeDevolver > 0) {
                if (auxiliar != debeDevolver) {
                    auxiliar = debeDevolver;
                    //Se espera devolver primero al denominación más alta que se pueda
                    if (debeDevolver >= 20000) {
                        Dinero unTipo = dinero[7];
                        if (unTipo.getCantidad() > 0) {
                            unTipo.setCantidad(1);
                            arregloDineroCambio.add(unTipo);
                            debeDevolver = debeDevolver - 20000;
                            //Disminuya la cantidad de esta denominación
                            dinero[7].setCantidad(dinero[7].getCantidad() - 1);
                        }
                    } if (debeDevolver >= 10000) {
                        Dinero unTipo = dinero[6];
                        if (unTipo.getCantidad() > 0) {
                            unTipo.setCantidad(1);
                            arregloDineroCambio.add(unTipo);
                            debeDevolver = debeDevolver - 10000;
                            //Disminuya la cantidad de esta denominación
                            dinero[6].setCantidad(dinero[6].getCantidad() - 1);
                        }

                    } if (debeDevolver >= 5000) {
                        Dinero unTipo = dinero[5];
                        if (unTipo.getCantidad() > 0) {
                            unTipo.setCantidad(1);
                            arregloDineroCambio.add(unTipo);
                            debeDevolver = debeDevolver - 5000;
                            //Disminuya la cantidad de esta denominación
                            dinero[5].setCantidad(dinero[5].getCantidad() - 1);
                        }

                    } if (debeDevolver >= 2000) {
                        Dinero unTipo = dinero[4];
                        if (unTipo.getCantidad() > 0) {
                            unTipo.setCantidad(1);
                            arregloDineroCambio.add(unTipo);
                            debeDevolver = debeDevolver - 2000;
                            //Disminuya la cantidad de esta denominación
                            dinero[4].setCantidad(dinero[4].getCantidad() - 1);
                        }

                    }  if (debeDevolver >= 1000) {

                        Dinero unTipo = dinero[3];
                         System.out.println(unTipo.getCantidad());
                        if (unTipo.getCantidad() > 0) {
                            System.out.println(unTipo.getCantidad());
                            arregloDineroCambio.add(unTipo);
                            debeDevolver = debeDevolver - 1000;
                            //Disminuya la cantidad de esta denominación
                            dinero[3].setCantidad(dinero[3].getCantidad() - 1);
                        }

                    } if (debeDevolver >= 500) {

                        Dinero unTipo = dinero[2];
                        if (unTipo.getCantidad() > 0) {
                            unTipo.setCantidad(1);
                            arregloDineroCambio.add(unTipo);
                            debeDevolver = debeDevolver - 500;
                            //Disminuya la cantidad de esta denominación
                            dinero[2].setCantidad(dinero[2].getCantidad() - 1);
                        }

                    } if (debeDevolver >= 200) {

                        Dinero unTipo = dinero[1];
                        if (unTipo.getCantidad() > 0) {
                            unTipo.setCantidad(1);
                            arregloDineroCambio.add(unTipo);
                            debeDevolver = debeDevolver - 200;
                            //Disminuya la cantidad de esta denominación
                            dinero[1].setCantidad(dinero[1].getCantidad() - 1);
                        }

                    } if (debeDevolver >= 100) {

                        Dinero unTipo = dinero[0];
                        if (unTipo.getCantidad() > 0) {
                            unTipo.setCantidad(1);
                            arregloDineroCambio.add(unTipo);
                            debeDevolver = debeDevolver - 100;
                            //Disminuya la cantidad de esta denominación
                            dinero[0].setCantidad(dinero[0].getCantidad() - 1);
                        }

                    }
                } else {
                    break;
                }
            }

            for (int i = 0; i < arregloDineroCambio.size(); i++) {
                totalCambio +=  arregloDineroCambio.get(i).getDenominacion();
            }

           

            return (totalCambio == debeDevolverFinal);

        } else {

            return debeDevolver == 0;

        }

    }

    //Calcula si la máquina tiene para devolver cambio
    //Retorna el cambio generado
    public String calcularCambio(int debeDevolver) {

        String cambio = "";
        int totalCambio = debeDevolver;
        int caja = getDineroCaja();

        if (caja >= debeDevolver) {

            while (debeDevolver > 0) {

                //Se espera devolver primero al denominación más alta que se pueda
                if (debeDevolver >= 20000) {
                    Dinero unTipo = arregloDineroCaja[7];
                    if (unTipo.getCantidad() > 0) {
                        unTipo.setCantidad(unTipo.getCantidad() - 1);
                        unTipo.setCantidad(1);
                        arregloDineroCambio.add(unTipo);
                        debeDevolver = debeDevolver - 20000;
                    }
                } else if (debeDevolver >= 10000) {
                    Dinero unTipo = arregloDineroCaja[6];
                    if (unTipo.getCantidad() > 0) {
                        unTipo.setCantidad(unTipo.getCantidad() - 1);
                        unTipo.setCantidad(1);
                        arregloDineroCambio.add(unTipo);
                        debeDevolver = debeDevolver - 10000;
                    }

                } else if (debeDevolver >= 5000) {
                    Dinero unTipo = arregloDineroCaja[5];
                    if (unTipo.getCantidad() > 0) {
                        unTipo.setCantidad(unTipo.getCantidad() - 1);
                        unTipo.setCantidad(1);
                        arregloDineroCambio.add(unTipo);
                        debeDevolver = debeDevolver - 5000;
                    }

                } else if (debeDevolver >= 2000) {

                    Dinero unTipo = arregloDineroCaja[4];
                    if (unTipo.getCantidad() > 0) {
                        unTipo.setCantidad(unTipo.getCantidad() - 1);
                        unTipo.setCantidad(1);
                        arregloDineroCambio.add(unTipo);
                        debeDevolver = debeDevolver - 2000;
                    }

                } else if (debeDevolver >= 1000) {

                    Dinero unTipo = arregloDineroCaja[3];
                    if (unTipo.getCantidad() > 0) {
                        unTipo.setCantidad(unTipo.getCantidad() - 1);
                        unTipo.setCantidad(1);
                        arregloDineroCambio.add(unTipo);
                        debeDevolver = debeDevolver - 1000;
                    }

                } else if (debeDevolver >= 500) {

                    Dinero unTipo = arregloDineroCaja[2];
                    if (unTipo.getCantidad() > 0) {
                        unTipo.setCantidad(unTipo.getCantidad() - 1);
                        unTipo.setCantidad(1);
                        arregloDineroCambio.add(unTipo);
                        debeDevolver = debeDevolver - 500;
                    }

                } else if (debeDevolver >= 200) {

                    Dinero unTipo = arregloDineroCaja[1];
                    if (unTipo.getCantidad() > 0) {
                        unTipo.setCantidad(unTipo.getCantidad() - 1);
                        unTipo.setCantidad(1);
                        arregloDineroCambio.add(unTipo);
                        debeDevolver = debeDevolver - 200;
                    }

                } else if (debeDevolver >= 100) {

                    Dinero unTipo = arregloDineroCaja[0];
                    if (unTipo.getCantidad() > 0) {
                        unTipo.setCantidad(unTipo.getCantidad() - 1);
                        unTipo.setCantidad(1);
                        arregloDineroCambio.add(unTipo);
                        debeDevolver = debeDevolver - 100;
                    }

                }
            }

            for (int i = 0; i < arregloDineroCambio.size(); i++) {
                cambio += "Se devuelven: " + arregloDineroCambio.get(i).getCantidad() + " de " + arregloDineroCambio.get(i).getDenominacion() + "\n";
            }

        } else if (debeDevolver != 0) {
            cambio = "No hay cambio suficiente. \n";
        } else {
            cambio = "No requiere cambio. \n";
        }

        return cambio;
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
    }

}
