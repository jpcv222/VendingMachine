import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
//import javax.swing.


public class Interfaz extends JFrame{

    JTabbedPane tab;
    JPanel pPrincipal, pAdministrador, pGrid,pSecundario, pSeleccionarProducto, pDialogoVenta, pSeccionPago, pMedioPago,
             pMonedas, pBilletes, pDinero, pOpciones, pReabastecer, pProductos, pVentas, pDialogoAdmin;;
    JLabel lIngresoCasilla, labelEncabezado, labelEncabezado2,jlCasilla, jlHoraInicial, jlHoraFinal;
    JTextField jtIngresoCasilla, jtCantidadDinero0, jtCantidadDinero1, jtCantidadDinero2, jtCantidadDinero3, jtCantidadDinero4,
            jtCantidadDinero5, jtCantidadDinero6, jtCantidadDinero7, jtCasilla, jtHoraInicial, jtHoraFinal;
    JButton  btEnviarCasilla, btEnviarPago, btAbastecer, btAbastecerTodo, btDineroProductos, btVentas, btProducto;
    JTextArea areaDialogo, aResultados;
    Container contenedor;
    BorderLayout borderPrincipal, borderSecundario, borderAdministracion;
    GridLayout gridPrincipal, gridProcesoPago, gridDinero, gridBotones;
    FlowLayout  flowSeleccionarProducto;
    JScrollPane scrollPaneVenta, scrollPaneAdmin;
    JRadioButton rbMonedas, rbBilletes, rbAmbos;
    ButtonGroup mediosPago;
    
 

    public Interfaz()
    {
        //Definir y asignar características a elementos de la interfaz
        //Contenedor
        contenedor = new Container();
        
        //Layouts
        borderPrincipal = new BorderLayout();
        borderSecundario = new BorderLayout();
        borderAdministracion = new BorderLayout();
        gridPrincipal = new GridLayout(10,4);
        gridProcesoPago = new GridLayout(2, 1);
        gridBotones = new GridLayout(3, 1);
        gridDinero = new GridLayout(4, 2);
        flowSeleccionarProducto = new FlowLayout();
        
        //Dimensiones
        Dimension dmnsn5 = new Dimension(30, 30);
        
        //Fuentes
        Font fuente = new Font("Tempus Sans ITC", Font.BOLD, 30);
        
        //Radio buttons
        
          // PARA VENTA
        
        rbMonedas = new JRadioButton("Monedas");
        rbBilletes = new JRadioButton("Billetes");
        rbAmbos = new JRadioButton("Ambos");
        
        rbMonedas.setActionCommand("Monedas");
        rbMonedas.setBackground(Color.white);
        rbBilletes.setActionCommand("Billetes");
        rbBilletes.setBackground(Color.white);
        rbAmbos.setActionCommand("Ambos");  
        rbAmbos.setBackground(Color.white);
        
//Buttons group 
        mediosPago = new ButtonGroup();
                
        mediosPago.add(rbAmbos);
        mediosPago.add(rbBilletes);
        mediosPago.add(rbMonedas);
        
        
        //Buttons
        btEnviarCasilla = new JButton();
        btEnviarCasilla.setContentAreaFilled(false);
        btEnviarCasilla.setPreferredSize(dmnsn5);
        btEnviarCasilla.setBorderPainted(false);
        btEnviarCasilla.setVerticalAlignment(0);
        btEnviarCasilla.setHorizontalAlignment(0);
        btEnviarCasilla.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/doneRoll.png")));
        btEnviarCasilla.setIcon(new ImageIcon(getClass().getResource("/imagenes/done.png")));
        btEnviarCasilla.setToolTipText("Enviar producto seleccionado.");
        
        btEnviarPago = new JButton();
        btEnviarPago.setContentAreaFilled(false);
        btEnviarPago.setPreferredSize(dmnsn5);
        btEnviarPago.setBorderPainted(false);
        btEnviarPago.setVerticalAlignment(0);
        btEnviarPago.setHorizontalAlignment(0);
        btEnviarPago.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/doneRoll.png")));
        btEnviarPago.setIcon(new ImageIcon(getClass().getResource("/imagenes/done.png")));
        btEnviarPago.setToolTipText("Enviar pago seleccionado.");
        btEnviarPago.setEnabled(false);
     
        
        //Labels
        lIngresoCasilla = new JLabel("Número de casilla");
        lIngresoCasilla.setToolTipText("El número rojo indica la casilla.");
        
        labelEncabezado = new JLabel("MÁQUINA DE VENDING");
        labelEncabezado.setFont(fuente);
        labelEncabezado.setForeground(Color.black);
        
        labelEncabezado2 = new JLabel("MÁQUINA DE VENDING (ADMINISTRACIÓN)");
        labelEncabezado2.setFont(fuente);
        labelEncabezado2.setForeground(Color.black);
        
        //JTextArea
        areaDialogo = new JTextArea(10,30);
        
        
        //Scrolls
        scrollPaneVenta = new JScrollPane(areaDialogo); 
        
        //JText
        jtIngresoCasilla = new JTextField();
        jtIngresoCasilla.setPreferredSize(dmnsn5);
        jtIngresoCasilla.setToolTipText("El número rojo indica la casilla.");
        
         jtCantidadDinero0 = new JTextField("0");
         jtCantidadDinero0.setPreferredSize(new Dimension(30, 30));
         jtCantidadDinero0.setToolTipText("Cantidad de monedas de esta denominación.");
         
         jtCantidadDinero1 = new JTextField("0");
         jtCantidadDinero1.setPreferredSize(new Dimension(30, 30));
         jtCantidadDinero1.setToolTipText("Cantidad de monedas de esta denominación.");
         
         jtCantidadDinero2 = new JTextField("0");
         jtCantidadDinero2.setPreferredSize(new Dimension(30, 30));
         jtCantidadDinero2.setToolTipText("Cantidad de monedas de esta denominación.");
         
         jtCantidadDinero3 = new JTextField("0");
         jtCantidadDinero3.setPreferredSize(new Dimension(30, 30));
         jtCantidadDinero3.setToolTipText("Cantidad de monedas de esta denominación.");
         
         jtCantidadDinero4 = new JTextField("0");
         jtCantidadDinero4.setPreferredSize(new Dimension(30, 30));
         jtCantidadDinero4.setToolTipText("Cantidad de billetes de esta denominación.");
         
         jtCantidadDinero5 = new JTextField("0");
         jtCantidadDinero5.setPreferredSize(new Dimension(30, 30));
         jtCantidadDinero5.setToolTipText("Cantidad de billetes de esta denominación.");
         
         jtCantidadDinero6 = new JTextField("0");
         jtCantidadDinero6.setPreferredSize(new Dimension(30, 30));
         jtCantidadDinero6.setToolTipText("Cantidad de billetes de esta denominación.");
         
         jtCantidadDinero7 = new JTextField("0");
         jtCantidadDinero7.setPreferredSize(new Dimension(30, 30));
         jtCantidadDinero7.setToolTipText("Cantidad de billetes de esta denominación.");
        
        
        //Paneles
        pPrincipal = new JPanel();
        pPrincipal.setLayout(borderPrincipal);
        //pPrincipal.setToolTipText("Presione cualquier lugar de la interfaz para actualizar.");
        pSecundario= new JPanel();
        pSecundario.setLayout(borderSecundario);
        pGrid = new JPanel();
        pGrid.setLayout(gridPrincipal);
        pAdministrador = new JPanel(borderAdministracion);
        pDialogoVenta = new JPanel();
        pSeccionPago = new JPanel();
        pMedioPago = new JPanel();
        pMonedas  = new JPanel(gridDinero);
        pBilletes = new JPanel(gridDinero);
        pDinero  = new JPanel(flowSeleccionarProducto);
        
        pBilletes.setBackground(Color.white);
        pMonedas.setBackground(Color.white);
        
        pDinero.setBorder(BorderFactory.createTitledBorder("Medio de pago"));
        pDinero.setBackground(Color.white);
        pDinero.setVisible(false);
        
        
        
        
        pMedioPago.setLayout(flowSeleccionarProducto);
        pMedioPago.add(rbMonedas);
        pMedioPago.add(rbBilletes);
        pMedioPago.add(rbAmbos);
        pMedioPago.setBackground(Color.white);
        
        pSeccionPago.setLayout(flowSeleccionarProducto);
        pSeccionPago.add(pMedioPago);
        pSeccionPago.add(btEnviarPago);
        pSeccionPago.add(pDinero);
        pSeccionPago.setBackground(Color.white);
        
        pDialogoVenta.setLayout(flowSeleccionarProducto);
        pDialogoVenta.add(scrollPaneVenta);
        pDialogoVenta.setBorder(BorderFactory.createTitledBorder("Área de diálogo"));
        pDialogoVenta.setBackground(Color.white);
        pSeleccionarProducto = new JPanel();
        pSeleccionarProducto.setLayout(flowSeleccionarProducto);
        
        pSeleccionarProducto.add(lIngresoCasilla);
        pSeleccionarProducto.add(jtIngresoCasilla);
        pSeleccionarProducto.add(btEnviarCasilla);
        pSeleccionarProducto.setBorder(BorderFactory.createTitledBorder("Seleccione su producto"));
        pSeleccionarProducto.setBackground(Color.LIGHT_GRAY);
        
        pSecundario.setPreferredSize(new Dimension(350, 690));
        pSecundario.setBorder(BorderFactory.createLineBorder(Color.blue));
        pSecundario.setBackground(Color.white);
        pSecundario.add(pSeleccionarProducto, BorderLayout.NORTH);
        pSecundario.add(pDialogoVenta, BorderLayout.SOUTH);
        pSecundario.add(pSeccionPago, BorderLayout.CENTER);
        pGrid.setBackground(Color.white);
     
        pPrincipal.add(pGrid,BorderLayout.CENTER);
        pPrincipal.add(pSecundario,BorderLayout.EAST);
        pPrincipal.add(labelEncabezado,BorderLayout.NORTH);
        pPrincipal.setBorder(BorderFactory.createLineBorder(Color.blue));
        pPrincipal.setBackground(Color.white);
        
  // PARA ADMINISTRACIÓN
        
        jlCasilla = new JLabel("Número de casilla a reabastecer: ");
        jlHoraInicial = new JLabel("Hora inicial (HH:MM) -Hora militar-: ");
        jlHoraFinal = new JLabel("Hora final (HH:MM) -Hora militar-: ");
        
        jtCasilla = new JTextField();
        jtCasilla.setPreferredSize(new Dimension(30, 30));
        jtCasilla.setToolTipText("Casilla a reabastecer.");
        jtHoraInicial = new JTextField();
        jtHoraInicial.setPreferredSize(new Dimension(60, 30));
        jtHoraInicial.setToolTipText("Hora inicial.");
        jtHoraFinal = new JTextField();
        jtHoraFinal.setPreferredSize(new Dimension(60, 30));
        jtHoraFinal.setToolTipText("Hora final.");
        
        btAbastecer = new JButton("Reabastecer una casilla");
        btAbastecerTodo = new JButton("Reabastecer vacíos");
        btDineroProductos = new JButton("Dinero por obtenido producto");
        btVentas = new JButton("Consultar ventas en intervalo de hora");
        btProducto = new JButton("Consultar producto de mayor venta");
        
        
        pReabastecer = new JPanel(flowSeleccionarProducto);
        pReabastecer.setBorder(BorderFactory.createLineBorder(Color.blue));
        pReabastecer.setBackground(Color.white);
        pReabastecer.add(jlCasilla);
        pReabastecer.add(jtCasilla);
        pReabastecer.add(btAbastecer);
        pReabastecer.add(btAbastecerTodo);
        
         
        pProductos = new JPanel(flowSeleccionarProducto);
        pProductos.setBorder(BorderFactory.createLineBorder(Color.blue));
        pProductos.setBackground(Color.white);
        pProductos.add(btDineroProductos);
        pProductos.add(btProducto);
        pProductos.add(new JLabel( new ImageIcon(getClass().getResource("/imagenes/pony.jpg"))));
        pProductos.add(new JLabel( new ImageIcon(getClass().getResource("/imagenes/cocacola.jpg"))));
        pProductos.add(new JLabel( new ImageIcon(getClass().getResource("/imagenes/milo.jpg"))));
        pProductos.add(new JLabel( new ImageIcon(getClass().getResource("/imagenes/jugoValle.jpg"))));
        pProductos.add(new JLabel( new ImageIcon(getClass().getResource("/imagenes/agua.jpg"))));
        pProductos.add(new JLabel( new ImageIcon(getClass().getResource("/imagenes/cafe.jpg"))));
        pProductos.add(new JLabel( new ImageIcon(getClass().getResource("/imagenes/hit.jpg"))));
        pProductos.add(new JLabel( new ImageIcon(getClass().getResource("/imagenes/colombiana.jpg"))));
        pProductos.add(new JLabel( new ImageIcon(getClass().getResource("/imagenes/poker.jpg"))));
        pProductos.add(new JLabel( new ImageIcon(getClass().getResource("/imagenes/sprite.jpg"))));
        
        pVentas = new JPanel(flowSeleccionarProducto);
        pVentas.setBorder(BorderFactory.createLineBorder(Color.blue));
        pVentas.setBackground(Color.white);
        pVentas.add(btVentas);
        pVentas.add(jlHoraInicial);
        pVentas.add(jtHoraInicial);
        pVentas.add(jlHoraFinal);
        pVentas.add(jtHoraFinal);
        
        pOpciones = new JPanel(gridBotones);
        pOpciones.setBackground(Color.white);
        pOpciones.setPreferredSize(new Dimension(350, 50));
        pOpciones.add(pReabastecer);
        pOpciones.add(pProductos);
        pOpciones.add(pVentas);
     
        aResultados = new JTextArea(30,40);
        scrollPaneAdmin = new JScrollPane(aResultados); 
        
        pDialogoAdmin = new JPanel();
 
        pDialogoAdmin.setLayout(flowSeleccionarProducto);
        pDialogoAdmin.setBackground(Color.white);
        pDialogoAdmin.add(scrollPaneAdmin);
        pDialogoAdmin.add(new JLabel("Creado por Juan Pablo Castro"));
        pDialogoAdmin.add(new JLabel("y por Juan Camilo Berrio"));
        pDialogoAdmin.add(new JLabel("Universidad del Valle"));
        pDialogoAdmin.setBorder(BorderFactory.createTitledBorder("Área de diálogo"));
        
        pAdministrador.add(pOpciones,BorderLayout.WEST);
        pAdministrador.add(pDialogoAdmin,BorderLayout.CENTER);
        pAdministrador.add(labelEncabezado2,BorderLayout.NORTH);
        pAdministrador.setBorder(BorderFactory.createLineBorder(Color.blue));
        pAdministrador.setBackground(Color.white);
        
        //JTabbedPane
        tab = new JTabbedPane();
   
        tab.add(pPrincipal, "Venta de productos");
        tab.add(pAdministrador, "Administración");
        
        contenedor = getContentPane();
        contenedor.add(tab);
        contenedor.setPreferredSize(new Dimension(900, 690));

        
       ManejadorEventos manejador = new ManejadorEventos();
       btEnviarCasilla.addActionListener(manejador);
       btEnviarPago.addActionListener(manejador);
       rbMonedas.addActionListener(manejador);
       rbBilletes.addActionListener(manejador);
       rbAmbos.addActionListener(manejador);
       btAbastecer.addActionListener(manejador);
       btAbastecerTodo.addActionListener(manejador);
       btDineroProductos.addActionListener(manejador);
       btProducto.addActionListener(manejador);
       btVentas.addActionListener(manejador);
       
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Interfaz obj = new Interfaz();
        obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //CREAR CLASE INTERNA PARA MANEJAR LOS EVENTOS

private class ManejadorEventos implements ActionListener {

Maquina unaMaquina;
Producto productoElegido;
int fila, columna;
int [] dineroIngresado = new int [8];

public ManejadorEventos() {
    

unaMaquina = new Maquina(new Dinero[8], new Producto[10][4]);

//Generar productos y medios de pago

generarMatriz();
generarDinero();
pintarMatriz();
}

//Distribuye en la interfaz los medios de pago. 
//Así como también lo hace en el arreglo interno de la clase Maquina
private void generarDinero(){
    try{
        Dinero unDinero;
        JPanel panelDinero;
        JLabel imagenDinero;
        JTextField cantidadDinero;

        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    unDinero = new Dinero("Moneda", "/imagenes/moneda1.jpg", 100, 0);
                    cantidadDinero = jtCantidadDinero0;
                    break;
                case 1:
                    unDinero = new Dinero("Moneda", "/imagenes/moneda2.jpg", 200, 0);
                    cantidadDinero = jtCantidadDinero1;
                    break;
                case 2:
                    unDinero = new Dinero("Moneda", "/imagenes/moneda3.jpg", 500, 0);
                    cantidadDinero = jtCantidadDinero2;
                    break;
                case 3:
                    unDinero = new Dinero("Moneda", "/imagenes/moneda4.jpg", 1000, 0);
                    cantidadDinero = jtCantidadDinero3;
                    break;
                case 4:
                    unDinero = new Dinero("Billete", "/imagenes/billete1.jpg", 2000, 0);
                    cantidadDinero = jtCantidadDinero4;
                    break;
                case 5:
                    unDinero = new Dinero("Billete", "/imagenes/billete2.jpg", 5000, 0);
                    cantidadDinero = jtCantidadDinero5;
                    break;
                case 6:
                    unDinero = new Dinero("Billete", "/imagenes/billete3.jpg", 10000, 0);
                    cantidadDinero = jtCantidadDinero6;
                    break;
                case 7:
                    unDinero = new Dinero("Billete", "/imagenes/billete4.jpg", 20000, 0);
                    cantidadDinero = jtCantidadDinero7;
                    break;
                default:
                    unDinero = new Dinero("No definido", "/imagenes/error.jpg", 0, 0);
                    cantidadDinero = new JTextField();
                    break;

            }
            
            //Agregar medio de pago a array interno
            unaMaquina.agregarMedioPago(unDinero, i);

            panelDinero = new JPanel(flowSeleccionarProducto);

            imagenDinero = new JLabel(new ImageIcon(getClass().getResource(unDinero.getUrlImagen())));
           

            panelDinero.setBackground(Color.WHITE);
            panelDinero.add(imagenDinero);
            panelDinero.add(cantidadDinero);

            if (unDinero.getTipo().equals("Moneda")) {
                pMonedas.add(panelDinero);
            } else if (unDinero.getTipo().equals("Billete")) {
                pBilletes.add(panelDinero);
            }

        }

        pDinero.add(pMonedas);
        pDinero.add(pBilletes);

        pMonedas.setVisible(false);
        pBilletes.setVisible(false);

    }
    catch(NullPointerException exc){
        //Si es borrada una imagen de la carpeta, puede causar una excepción 
    
    }
   
}

//Limpia pGrid para luego generar matriz 
private void limpiarMatriz(){
        pGrid.removeAll();
}

//Distribuye los productos en el grid de la interfaz según matriz de la clase Maquina
private void pintarMatriz(){
    
    limpiarMatriz();
    
    Producto[][] matrizMaquina = unaMaquina.getMatrizMaquina();
    Producto unProducto;
    
      for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                
            unProducto = matrizMaquina[i][j];
                
              JPanel panelProducto = new JPanel(), panelCasilla = new JPanel();
              JLabel labelCasilla  = new JLabel(String.valueOf(unProducto.getUbicacion()));
              JLabel producto = new JLabel();
              if(!unaMaquina.validarStockCasilla(i, j)){
                 producto.setIcon(new ImageIcon(getClass().getResource("/imagenes/agotado.jpg")));
              }else {
                 producto.setIcon(new ImageIcon(getClass().getResource(unProducto.getUrlImagen()))); 
              }
             
              JLabel precioProducto= new JLabel ("$" + String.valueOf(unProducto.getPrecio()));
              precioProducto.setToolTipText("Precio");
              
              producto.setToolTipText(unProducto.getNombre());
              
              labelCasilla.setForeground(Color.RED);
              labelCasilla.setToolTipText("Número de casilla");
              
              
              
              panelProducto.setLayout(new FlowLayout());
              panelProducto.add(producto);
              panelProducto.setBackground(Color.white);
              
              panelCasilla.setLayout(new BorderLayout());
              panelCasilla.setBorder(BorderFactory.createLineBorder(Color.black));
              panelCasilla.setBackground(Color.white);
              panelCasilla.add(panelProducto, BorderLayout.CENTER);
              panelCasilla.add(labelCasilla, BorderLayout.WEST);
              panelCasilla.add(precioProducto, BorderLayout.EAST);
              panelCasilla.add(new JLabel("Cant. "+unProducto.getCantidad()), BorderLayout.NORTH);
              pGrid.add(panelCasilla);
            
            }
      }
      
         //Agregar producto y especificaciones del mismo a la interfaz.
              
    
}


//Distribuye los productos de manera aleatoria en la matriz interna de la clase Maquina
private void generarMatriz(){
    int aleatorio, contadorUbicacion= 0;  
    
/*for que autocompleta los articulos a vender:
    1 es: Pony malta
    2 es: CocaCola
    3 es: Milo
    4 es: Jugo del Valle
    5 es: Agua
    6 es: Café
    7 es: Hit
    8 es: Colombiana
    9 es: Poker
    10 es: Sprite
*/             

Producto unProducto;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
              
              contadorUbicacion += 1;  
              aleatorio = (int) Math.floor(Math.random()*(10)+1);
              
              
              switch(aleatorio){
                  case 1:  
                      unProducto = new Producto("Pony Malta","/imagenes/pony.jpg",2000,contadorUbicacion,10);
                  break;
                  case 2:  
                        unProducto = new Producto("CocaCola","/imagenes/cocacola.jpg",2000,contadorUbicacion,10);
                  break;
                  case 3: 
                        unProducto = new Producto("Milo","/imagenes/milo.jpg",1500,contadorUbicacion,10);
                  break;
                  case 4: 
                        unProducto = new Producto("Jugo del valle","/imagenes/jugoValle.jpg",1000,contadorUbicacion,10);
                  break;
                  case 5:   
                        unProducto = new Producto("Agua","/imagenes/agua.jpg",1000,contadorUbicacion,1);
                  break;
                  case 6:   
                        unProducto = new Producto("Café","/imagenes/cafe.jpg",1000,contadorUbicacion,10);
                  break;
                  case 7:   
                        unProducto = new Producto("Hit","/imagenes/hit.jpg",1000,contadorUbicacion,10);
                  break;
                  case 8:   
                        unProducto = new Producto("Colombiana","/imagenes/colombiana.jpg",2000,contadorUbicacion,10);
                  break;
                  case 9:   
                        unProducto = new Producto("Poker","/imagenes/poker.jpg",3500,contadorUbicacion,10);
                  break;
                  case 10:   
                        unProducto = new Producto("Sprite","/imagenes/sprite.jpg",1700,contadorUbicacion,10);
                  break;
                  default:
                      unProducto = new Producto("No existe","/imagenes/error.jpg",0,contadorUbicacion,0);
                      break;
              }
              
              //Agregar producto a matriz interna de la máquina
              unaMaquina.agregarProducto(unProducto, i, j);
                
              
            }
            
            
        }

}

//Setea a los jtext donde se ingresa el dinero el valor 0
private  void setJtDineroCeros(){

    jtCantidadDinero0.setText("0");
    jtCantidadDinero1.setText("0");
    jtCantidadDinero2.setText("0");
    jtCantidadDinero3.setText("0");
    jtCantidadDinero4.setText("0");
    jtCantidadDinero5.setText("0");
    jtCantidadDinero6.setText("0");
    jtCantidadDinero7.setText("0");
}

//Valida que la venta sea exitosa según condiciones de pago
private void validarVenta(int total, int precio){
    int cambio = 0;
    
  
       
        if(unaMaquina.validarIngreso(total, precio) && unaMaquina.validarCambio(total-precio) ){
        //Ingresó un valor válido y hay cambio si se necesita
        
            if (unaMaquina.validarStockCasilla(fila, columna)) {
                //El producto tiene stock en la casilla seleccionada

                if (total > precio) {
                    //Calcule cambio
                    //Venda producto
                    cambio = total - precio;

                }

                areaDialogo.append(unaMaquina.vender(productoElegido, fila, columna, total, cambio));
                //areaDialogo.append(unaMaquina.calcularCambio(total-precio));
                areaDialogo.append(unaMaquina.ruturaStock(productoElegido));
                   
                areaDialogo.append("PRESIONE ALGÚN LUGAR DE LA GUI PARA ACTUALIZAR INTERFAZ.\n");

            }else {
            areaDialogo.append("Producto "+ productoElegido.getNombre() + " AGOTADO en la casilla \n \n");
            }
        
        
      
  
        btEnviarPago.setEnabled(false);
        jtIngresoCasilla.setText("");
    } else {
        areaDialogo.append("Dinero insuficiente para pagar o dar cambio. \n");
        areaDialogo.append("Se regresa el monto de: $" + total + " \n");
        areaDialogo.append("Vuelva a ingresar su dinero o elija otro producto \n \n");
      
    }
        
          setJtDineroCeros();
    
    
}
@Override
public void actionPerformed(ActionEvent e) {
    
    if(e.getSource() == btAbastecer){
        
           int numeroCasilla, precio;
        String nombre;
        //Validar número de casilla
        try {
            numeroCasilla = Integer.parseInt(jtCasilla.getText());
            if(numeroCasilla >= 1 && numeroCasilla <= 40){
            
            //Traer los equivalentes en la matriz interna según casilla ingresada.
            fila = unaMaquina.getFila(numeroCasilla);
            columna = unaMaquina.getColumna(numeroCasilla);
           
            aResultados.append("Casilla digitada válida. \n \n");
            
            if(fila != -99 && columna != -99){
                //La conversión es exitosa, y debe validar si la casilla está vacía.
                if(!unaMaquina.validarStockCasilla(fila, columna)){
                //Abastecer casilla.
                unaMaquina.reabastecer(fila, columna);
                aResultados.append("Se ha reabastecido con éxito. \n");
                pintarMatriz();
                }else{
                aResultados.append("La casilla no está vacía. \n");
                }

            }else{
                
            //Si el retorno es -99, la conversión falló.
             JOptionPane.showMessageDialog(null, "Error de conversión.\n Informe al área de sistemas.", "Compra de producto.", JOptionPane.ERROR_MESSAGE);
            }
            
            }else{
            aResultados.append("La casilla digitada no es válida. \n \n");
            }
        } catch (NumberFormatException exc) {
            aResultados.append("Dato no válido.  Campos vacíos o no enteros.\n \n");
        }
    
    }
    if(e.getSource() == btAbastecerTodo){
        
        String respuesta = unaMaquina.reabastecerTodo();
        if(respuesta.equals("")){
        aResultados.append("No se reabasteció ningún producto. \n");
        }else{
        aResultados.append(respuesta);
        pintarMatriz();
        }
        
    }
    if(e.getSource() == btDineroProductos){
        aResultados.append(unaMaquina.dineroPorProducto());
    }
    if(e.getSource() == btProducto){
        aResultados.append(unaMaquina.productoMasVendido());
    }
    if(e.getSource() == btVentas){
        
      String horaInicio, horaFin;
      horaInicio = jtHoraInicial.getText();
      horaFin    = jtHoraFinal.getText();
      
      aResultados.append(unaMaquina.ventasIntervalo(horaInicio, horaFin));
    }
    
    if(e.getSource() == btEnviarCasilla){

        int numeroCasilla, precio;
        String nombre;
        //Validar número de casilla
        try {
            numeroCasilla = Integer.parseInt(jtIngresoCasilla.getText());
            if(numeroCasilla >= 1 && numeroCasilla <= 40){
            
            //Traer los equivalentes en la matriz interna según casilla ingresada.
            fila = unaMaquina.getFila(numeroCasilla);
            columna = unaMaquina.getColumna(numeroCasilla);
           
            areaDialogo.append("Casilla digitada válida. \n \n");
            
            if(fila != -99 && columna != -99){
                //La conversión es exitosa, y debe traer la información del producto.
                productoElegido = unaMaquina.getMatrizMaquina()[fila][columna];
                nombre = productoElegido.getNombre();
                precio = productoElegido.getPrecio();
                
                areaDialogo.append("Producto elegido: "+ nombre+" \n");
                areaDialogo.append("Precio: "+precio + "\n");
                btEnviarPago.setEnabled(true);
                btEnviarCasilla.setText("");
            }else{
                
            //Si el retorno es -99, la conversión falló.
             JOptionPane.showMessageDialog(null, "Error de conversión.\n Informe al área de sistemas.", "Compra de producto.", JOptionPane.ERROR_MESSAGE);
            }
            
            }else{
            areaDialogo.append("La casilla digitada no es válida. \n \n");
            }
        } catch (NumberFormatException exc) {
            areaDialogo.append("Dato no válido. Campos vacíos o no enteros. \n \n");
        }
        
    }
    
    if(e.getSource() == rbMonedas){
       //areaDialogo.append("Eligió monedas. \n");
       pDinero.setVisible(true);
       pMonedas.setVisible(true);
       pBilletes.setVisible(false);
    }
    
    if(e.getSource() == rbBilletes){
      // areaDialogo.append("Eligió billetes. \n");
      pDinero.setVisible(true);
      pMonedas.setVisible(false);
      pBilletes.setVisible(true);
    }
    
    if(e.getSource() == rbAmbos){
       //areaDialogo.append("Eligió ambos. \n");
      pDinero.setVisible(true);
      pMonedas.setVisible(true);
      pBilletes.setVisible(true);
    }
    
    if(e.getSource() == btEnviarPago){
        
        try {
            
              String seleccion = mediosPago.getSelection().getActionCommand();
              
            switch (seleccion) {
                case "Monedas":
                    try{
                        
                        int moneda1, moneda2, moneda3, moneda4, total, tmoneda1, tmoneda2, tmoneda3, tmoneda4, precio;
                        precio = productoElegido.getPrecio();
                        
                        
                        //Se trae cantidad de dinero por denominación
                        moneda1 = Integer.parseInt(jtCantidadDinero0.getText()) ;
                        moneda2 = Integer.parseInt(jtCantidadDinero1.getText()) ;
                        moneda3 = Integer.parseInt(jtCantidadDinero2.getText()) ;
                        moneda4 = Integer.parseInt(jtCantidadDinero3.getText()) ;
                        
                        //Se convierte cantidad de tipo de dinero, a valor de ese dinero
                        tmoneda1 = moneda1 * 100;
                        tmoneda2 = moneda2 * 200;
                        tmoneda3 = moneda3 * 500;
                        tmoneda4 = moneda4 * 1000;
                        
                        total = tmoneda1 + tmoneda2 + tmoneda3 + tmoneda4;
                        
                        //Modificar dineroIngresado según el dinero ingresado
                        dineroIngresado[0] = moneda1;
                        dineroIngresado[1] = moneda2;
                        dineroIngresado[2] = moneda3;
                        dineroIngresado[3] = moneda4;
                        dineroIngresado[4] = 0;
                        dineroIngresado[5] = 0;
                        dineroIngresado[6] = 0;
                        dineroIngresado[7] = 0;
                        
                        validarVenta(total, precio);
                        
                    }
                    catch(NumberFormatException excp){
                        areaDialogo.append("Dato no válido. Campos vacíos o no enteros.\n");
                    } break;
                case "Billetes":
                    try{
                        
                        int billete1, billete2, billete3, billete4, total, tbillete1, tbillete2, tbillete3, tbillete4, precio;
                        precio = productoElegido.getPrecio();
                        
                        //Se trae cantidad de dinero por denominación
                        billete1 = Integer.parseInt(jtCantidadDinero4.getText()) ;
                        billete2 = Integer.parseInt(jtCantidadDinero5.getText()) ;
                        billete3 = Integer.parseInt(jtCantidadDinero6.getText()) ;
                        billete4 = Integer.parseInt(jtCantidadDinero7.getText()) ;
                        
                        //Se convierte cantidad de tipo de dinero, a valor de ese dinero
                        tbillete1 = billete1 * 2000;
                        tbillete2 = billete2 * 5000;
                        tbillete3 = billete3 * 10000;
                        tbillete4 = billete4 * 20000;
                        
                        total = tbillete1 + tbillete2 + tbillete3 + tbillete4;
                        
                        //Modificar dineroIngresado según el dinero ingresado
                        dineroIngresado[0] = 0;
                        dineroIngresado[1] = 0;
                        dineroIngresado[2] = 0;
                        dineroIngresado[3] = 0;
                        dineroIngresado[4] = billete1;
                        dineroIngresado[5] = billete2;
                        dineroIngresado[6] = billete3;
                        dineroIngresado[7] = billete4;
                        
                        validarVenta(total, precio);
                        
                    }
                    catch(NumberFormatException excp){
                        areaDialogo.append("Dato no válido. Campos vacíos o no enteros. \n");
                    }   break;
                case "Ambos":
                    try{
                        
                        int moneda1, moneda2, moneda3, moneda4, billete1, billete2, billete3, billete4, total,
                                tmoneda1, tmoneda2, tmoneda3, tmoneda4, tbillete1, tbillete2, tbillete3, tbillete4, precio;
                        
                        precio = productoElegido.getPrecio();
                        
                        //Se trae cantidad de dinero por denominación
                        
                        moneda1 = Integer.parseInt(jtCantidadDinero0.getText()) ;
                        moneda2 = Integer.parseInt(jtCantidadDinero1.getText()) ;
                        moneda3 = Integer.parseInt(jtCantidadDinero2.getText()) ;
                        moneda4 = Integer.parseInt(jtCantidadDinero3.getText()) ;
                        
                        
                        billete1 = Integer.parseInt(jtCantidadDinero4.getText()) ;
                        billete2 = Integer.parseInt(jtCantidadDinero5.getText()) ;
                        billete3 = Integer.parseInt(jtCantidadDinero6.getText()) ;
                        billete4 = Integer.parseInt(jtCantidadDinero7.getText()) ;
                        
                        //Se convierte cantidad de tipo de dinero, a valor de ese dinero

                        tmoneda1 = moneda1 * 100;
                        tmoneda2 = moneda2 * 200;
                        tmoneda3 = moneda3 * 500;
                        tmoneda4 = moneda4 * 1000;
                        
                        tbillete1 = billete1 * 2000;
                        tbillete2 = billete2 * 5000;
                        tbillete3 = billete3 * 10000;
                        tbillete4 = billete4 * 20000;
                        
                        
                        total = tbillete1 + tbillete2 + tbillete3 + tbillete4+ tmoneda1 + tmoneda2 + tmoneda3 + tmoneda4;
                        
                        //Modificar dineroIngresado según el dinero ingresado
                        dineroIngresado[0] = moneda1;
                        dineroIngresado[1] = moneda2;
                        dineroIngresado[2] = moneda3;
                        dineroIngresado[3] = moneda4;
                        dineroIngresado[4] = billete1;
                        dineroIngresado[5] = billete2;
                        dineroIngresado[6] = billete3;
                        dineroIngresado[7] = billete4;
                        
                        validarVenta(total, precio);
                        
                    }
                    catch(NumberFormatException excp){
                        areaDialogo.append("Dato no válido. Campos vacíos o no enteros. \n");
                    }   break;
                default:
                    //No ha seleccionado ninguno
                    areaDialogo.append("Selección no válida. \n");
                    break;
            }
            
        }catch(NullPointerException excpx){
            
        areaDialogo.append("No ha realizado selección de medio de pago.  \n");
        }
        
           pintarMatriz();

    }
    
        //String seleccion = mediosPago.getSelection().getActionCommand();
        //areaDialogo.append(seleccion);


}

}
    
}