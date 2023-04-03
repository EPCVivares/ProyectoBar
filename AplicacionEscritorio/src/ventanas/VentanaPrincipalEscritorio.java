/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import controlador.ConexionDB;
import controlador.Consultas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import modelo.Trabajador;
import modelo.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Esme
 */
public class VentanaPrincipalEscritorio extends JFrame implements ActionListener {
    
    private JPanel panelSuperior, panelInferior;
    private JTabbedPane panelCentral;
    private JButton[] botones;
    private final String[] nombreImagenes = {"abrir.jpg", "guardar.png", "salir.png", "informe.png","web.png"};
    private JToolBar barraHerramientas;
    private final String[] titulosPanelesAdministrador = {"Gestión Mesas", "Gestión Usuarios", "Gestión Clientes", "Gestión Trabajadores", "Gestión Reservas", "Gestión Productos", "Gestión Pedidos", "Insertar productos a pedidos"};
    private final String[] titulosPaneles = {"Gestión Productos", "Gestión Pedidos", "Insertar productos a pedidos"};
    private final int[] mnemotecnicosPestaniasAdministrador = {KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8};
    private final int[] mnemotecnicosPestanias = {KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3};
    private String enlaceWeb = "https://sites.google.com/view/cafeterabar/inicio";
    
    public VentanaPrincipalEscritorio(String telefono) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMaximumSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
        setMinimumSize(new Dimension(1000, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Gestión Bar/Cafetería");
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
        iniciarComponentes(telefono);
        setVisible(true);
    }
    
    private void iniciarComponentes(String telefono) {
        iniciarPanelSuperior();
        iniciarPanelCentral(telefono);
        iniciarPanelInferior(telefono);
    }
    
    private void iniciarPanelSuperior() {
        
        panelSuperior = new JPanel();
        barraHerramientas = new JToolBar();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
        botones = new JButton[nombreImagenes.length];
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton();
            botones[i].setIcon(new ImageIcon(getClass().getResource("/imagenes/" + nombreImagenes[i])));
            botones[i].setName(nombreImagenes[i]);
            botones[i].addActionListener(this);
            barraHerramientas.add(botones[i]);
        }
        panelSuperior.add(barraHerramientas);
        add(panelSuperior, BorderLayout.NORTH);
        
    }// Fin iniciarPanelSuperior

    private void iniciarPanelCentral(String telefono) {
        Usuario user = Consultas.existeUsuario("usuarios",new Usuario(telefono));
        int idUsuario = user.getIdUsuario();
        Trabajador trabajador = Consultas.existeTrabajador(new Trabajador(idUsuario));
        if (trabajador.getCategoria().equalsIgnoreCase("Administrador")) {
            panelCentral = new JTabbedPane();
            JPanel[] paneles = new JPanel[titulosPanelesAdministrador.length];
            panelCentral.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            for (int i = 0; i < paneles.length; i++) {
                paneles[i] = new JPanel();
                paneles[i].setLayout(new GridLayout(1, 1));
                switch (titulosPanelesAdministrador[i]) {
                    case "Gestión Usuarios" ->
                        paneles[i].add(new GestionUsuarios());
                    case "Gestión Clientes" ->
                        paneles[i].add(new GestionClientes());
                    case "Gestión Trabajadores" ->
                        paneles[i].add(new GestionTrabajadores());
                    case "Gestión Reservas" ->
                        paneles[i].add(new GestionReservas());
                    case "Gestión Mesas" ->
                        paneles[i].add(new GestionMesas());
                    case "Gestión Pedidos" ->
                        paneles[i].add(new GestionPedidos());
                    case "Gestión Productos" ->
                        paneles[i].add(new GestionProductos());
                    case "Insertar productos a pedidos" ->
                        paneles[i].add(new GestionProductos_Pedidos());  
                }
                panelCentral.add(paneles[i]);
                panelCentral.setTitleAt(i, titulosPanelesAdministrador[i]);
                panelCentral.setMnemonicAt(i, mnemotecnicosPestaniasAdministrador[i]);
            }
        //
        } else if (trabajador.getCategoria().equalsIgnoreCase("Camarero") || trabajador.getCategoria().equals("Cocinero")) {
            panelCentral = new JTabbedPane();
            JPanel[] paneles = new JPanel[titulosPaneles.length];
            panelCentral.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            for (int i = 0; i < paneles.length; i++) {
                paneles[i] = new JPanel();
                switch (titulosPaneles[i]) {
                    case "Gestión Pedidos" ->
                        paneles[i].add(new GestionPedidos());
                    case "Gestión Productos" ->
                        paneles[i].add(new GestionProductos());
                    case "Insertar productos a pedidos" ->
                        paneles[i].add(new GestionProductos_Pedidos());
                    default -> {
                    }
                }
                panelCentral.add(paneles[i]);
                panelCentral.setTitleAt(i, titulosPaneles[i]);
                panelCentral.setMnemonicAt(i, mnemotecnicosPestanias[i]);
            }
        }
            add(panelCentral, BorderLayout.CENTER);
        } // Fin método iniciarPanelCentral

    

    private void iniciarPanelInferior(String telefono) {
        Usuario user = Consultas.existeUsuario("usuarios",new Usuario(telefono));
        int idUsuario = user.getIdUsuario();
        Trabajador trabajador = Consultas.existeTrabajador(new Trabajador(idUsuario));
        panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel label = new JLabel("Usuario: " + user.getNombre() + ", Apellidos: " + user.getApellidos() + ", Categoría: " + trabajador.getCategoria());
        panelInferior.add(label);
        add(panelInferior, BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        switch (boton.getName()) {
            //Hacer metodo para abrir ficheros u otra cosa
            case "abrir.jpg" -> {
                
            }
            //Hacer metodo para guardar ficheros u otra cosa
            case "guardar.png" -> {
                
            }
            case "salir.png" -> {
                new VentanaLogin();
                dispose();
            }
            case "informe.png" -> {
                cierreCaja();
            }
            case "web.png" -> {
                try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +enlaceWeb);
                } catch (IOException ioe) {
                }
            }
        }
        
    }
    
    private void cierreCaja() {
        try {
            //Indicamos las carpetas donde se encuentra el origen y destino del informe
            String reportSource = "src/informes/plantillas/informesClientes.jrxml";
            String reportDest = "src/informes/resultados/informesClientes.html";

            //Crear un mapa para guardar parametros que podemos pasar al informe
            Map<String, Object> params = new HashMap<>();

            //Compilamos el informe .jrxml  para generar el .jasper
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

            //Creamos la conexion a la bd para poder rellenar el .jasper con los datos de la bd
            ConexionDB cbd = new ConexionDB();
            Connection conn = cbd.abrirConexion();

            //Cargamos los datos en el jasper pasandole los parámetros y la conexion a la BD
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

           //Exportamos el informe
           JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);
           //JasperExportManager.exportReportToPdf(jasperPrint); //Error: no funciona

            //Y lo visualizamos
            //JasperViewer.viewReport(jasperPrint);
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.show();
        } catch (JRException ex) {
            
        }
    }
    
}
