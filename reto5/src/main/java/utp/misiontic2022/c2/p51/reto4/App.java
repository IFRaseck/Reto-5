package utp.misiontic2022.c2.p51.reto4;

import utp.misiontic2022.c2.p51.reto4.vista.VentanaRequerimiento;
import utp.misiontic2022.c2.p51.reto4.vista.VistaRequerimientos;

public class App 
{
    public static void main( String[] args )
    {
        // System.out.println("Requerimiento 1");
        // VistaRequerimientos.requerimiento1();

        // System.out.println("\nRequerimiento 2");
        // VistaRequerimientos.requerimiento2();

        // System.out.println("\nRequerimiento 3");
        // VistaRequerimientos.requerimiento3();

        var vista = new VentanaRequerimiento();
        vista.setVisible(true);
        
    }
}
