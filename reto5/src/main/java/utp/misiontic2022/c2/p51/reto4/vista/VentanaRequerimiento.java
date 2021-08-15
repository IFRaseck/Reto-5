package utp.misiontic2022.c2.p51.reto4.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import utp.misiontic2022.c2.p51.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.*;

public class VentanaRequerimiento extends JFrame{
    private ControladorRequerimientos controlador;
    JTable tabla = new JTable();
    JTable tabla2 = new JTable();
    JTable tabla3 = new JTable();

    public VentanaRequerimiento(){
        controlador = new ControladorRequerimientos();
        initUI();
        setLocationRelativeTo(null);
    }

    private void initUI(){
        setTitle("Interfaz Reto5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);

        var panelPestañas = new JTabbedPane();
        getContentPane().add(panelPestañas, BorderLayout.CENTER);

        //CONSULTA 1

        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        panelPestañas.addTab("Consulta de requerimiento 1", panel);
        panelPestañas.setForeground(new Color(21,90,95));
        var panelInicio = new JPanel();

        JLabel nombreRequerimiento = new JLabel("Requerimiento1");
        nombreRequerimiento.setForeground(Color.WHITE);
        panelInicio.add(nombreRequerimiento);
        panelInicio.setBackground(new Color(49,137,133));
        
        var botonBusqueda = new JButton("Busqueda");
        botonBusqueda.addActionListener(e -> cargarTablaConsulta());
        botonBusqueda.setBackground(new Color(27,222,154));
        botonBusqueda.setForeground(new Color(21,90,95));

        panelInicio.add(botonBusqueda);
        panel.add(panelInicio, BorderLayout.PAGE_START);
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

        tabla.setBackground(new Color(254,255,247));
        tabla.setForeground(new Color(59,93,131));
        tabla.getBorder();

        //CONSULTA 2

        var panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        panelPestañas.addTab("Consulta de requerimiento 2", panel2);
        panelPestañas.setForeground(new Color(21,90,95));
        var panelInicio2 = new JPanel();

        JLabel nombreRequerimiento2 = new JLabel("Requerimiento2");
        nombreRequerimiento2.setForeground(Color.WHITE);
        panelInicio2.add(nombreRequerimiento2);
        panelInicio2.setBackground(new Color(49,137,133));

        var botonBusqueda2 = new JButton("Busqueda");
        botonBusqueda2.addActionListener(e -> cargarTablaConsulta2());
        botonBusqueda2.setBackground(new Color(27,222,154));
        botonBusqueda2.setForeground(new Color(21,90,95));

        panelInicio2.add(botonBusqueda2);
        panel2.add(panelInicio2, BorderLayout.PAGE_START);
        panel2.add(new JScrollPane(tabla2), BorderLayout.CENTER);
        
        tabla2.setBackground(new Color(254,255,247));
        tabla2.setForeground(new Color(59,93,131));
        tabla2.getBorder();

        //CONSULTA 3

        var panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());

        panelPestañas.addTab("Consulta de requerimiento 3", panel3);
        panelPestañas.setForeground(new Color(21,90,95));
        var panelInicio3 = new JPanel();

        JLabel nombreRequerimiento3 = new JLabel("Requerimiento3");
        nombreRequerimiento3.setForeground(Color.WHITE);
        panelInicio3.add(nombreRequerimiento3);
        panelInicio3.setBackground(new Color(49,137,133));

        var botonBusqueda3 = new JButton("Busqueda");
        botonBusqueda3.addActionListener(e -> cargarTablaConsulta3());
        botonBusqueda3.setBackground(new Color(27,222,154));
        botonBusqueda3.setForeground(new Color(21,90,95));

        panelInicio3.add(botonBusqueda3);
        panel3.add(panelInicio3, BorderLayout.PAGE_START);
        panel3.add(new JScrollPane(tabla3), BorderLayout.CENTER);
        
        tabla3.setBackground(new Color(254,255,247));
        tabla3.setForeground(new Color(59,93,131));
        tabla3.getBorder();
    }

    private void cargarTablaConsulta(){
        try {
            var lista = controlador.consultarRequerimiento1();
            var tableModel1 = new Requerimiento1TableModel1();
            tableModel1.setInfoTabla(lista);
            tabla.setModel(tableModel1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        } 
    }

    private void cargarTablaConsulta2(){
        try {
            var lista2 = controlador.consultarRequerimiento2();
        var tableModel2 = new Requerimiento1TableModel2();
        tableModel2.setInfoTabla2(lista2);
        tabla2.setModel(tableModel2);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        } 
    }

    private void cargarTablaConsulta3(){
        try {
            var lista3 = controlador.consultarRequerimiento3();
            var tableModel3 = new Requerimiento1TableModel3();
            tableModel3.setInfoTabla3(lista3);
            tabla3.setModel(tableModel3);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        } 
    }

    private class Requerimiento1TableModel1 extends AbstractTableModel{
        private ArrayList<Requerimiento_1> infoTabla;

        public void setInfoTabla(ArrayList<Requerimiento_1> infoTabla) {
            this.infoTabla = infoTabla;
        }

        @Override
        public int getRowCount() {
            return infoTabla.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = infoTabla.get(rowIndex);

            switch(columnIndex){
                case 0:
                    return registro.getNombreMaterial();
                case 1:
                    return registro.getPrecioUnidad();
            }
            return null;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch(columnIndex){
                case 0:
                    return String.class;
                case 1:
                    return Integer.class;
            }
            return super.getColumnClass(columnIndex);
        }

        

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0:
                    return "Nombre Material";
                case 1:
                    return "Precio Unidad";
            }
            return super.getColumnName(column);
        }
    }

    private class Requerimiento1TableModel2 extends AbstractTableModel{
        private ArrayList<Requerimiento_2> infoTabla2;
    
        public void setInfoTabla2(ArrayList<Requerimiento_2> infoTabla2) {
            this.infoTabla2 = infoTabla2;
        }
    
        @Override
        public int getRowCount() {
            return infoTabla2.size();
        }
    
        @Override
        public int getColumnCount() {
            return 2;
        }
    
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = infoTabla2.get(rowIndex);
    
            switch(columnIndex){
                case 0:
                    return registro.getConstructora();
                case 1:
                    return registro.getCiudad();
            }
            return null;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch(columnIndex){
                case 0:
                    return String.class;
                case 1:
                    return String.class;
            }
        return super.getColumnClass(columnIndex);
        }
        
    
        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0:
                    return "Constructora";
                case 1:
                    return "Ciudad";
            }
            return super.getColumnName(column);
        }
    }

    private class Requerimiento1TableModel3 extends AbstractTableModel{
        private ArrayList<Requerimiento_3> infoTabla3;
    
        public void setInfoTabla3(ArrayList<Requerimiento_3> infoTabla3) {
            this.infoTabla3 = infoTabla3;
        }
    
        @Override
        public int getRowCount() {
            return infoTabla3.size();
        }
    
        @Override
        public int getColumnCount() {
            return 5;
        }
    
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = infoTabla3.get(rowIndex);
    
            switch(columnIndex){
                case 0:
                    return registro.getProveedor();
                case 1:
                    return registro.getNombre_material();
                case 2:
                    return registro.getImportado();
                case 3:
                    return registro.getPrecio_Unidad();
                case 4:
                    return registro.getCantidad();
            }
            return null;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch(columnIndex){
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return Integer.class;
                case 4:
                    return Integer.class;
            }
        return super.getColumnClass(columnIndex);
        }
    
        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0:
                    return "Proveedor";
                case 1:
                    return "Material";
                case 2:
                    return "Importado";
                case 3:
                    return "Precio unidad";
                case 4:
                    return "Cantidad";
            }
            return super.getColumnName(column);
        }
    }
}


