package utp.misiontic2022.c2.p51.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p51.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
        var respuesta = new ArrayList<Requerimiento_3>();
        
        String consulta = "SELECT  c.Proveedor , mc.Nombre_Material , mc.Importado , mc.Precio_Unidad , SUM(C.Cantidad) Cantidad"
                        + " FROM MaterialConstruccion mc"
                        + " JOIN Compra c ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion"
                        + " WHERE c.Proveedor = 'Homecenter' AND mc.Importado = 'Si'"
                        + " GROUP BY mc.ID_MaterialConstruccion , c.Proveedor"
                        + " HAVING SUM(c.Cantidad) > 100"
                        + " ORDER BY mc.Nombre_Material";

        try(var connection = JDBCUtilities.getConnection();
            var statement = connection.prepareStatement(consulta);
            var rset = statement.executeQuery()){

                while(rset.next()){
                    var requerimiento_3VO = new Requerimiento_3();
                    requerimiento_3VO.setProveedor(rset.getString("Proveedor"));
                    requerimiento_3VO.setNombre_material(rset.getString("Nombre_Material"));
                    requerimiento_3VO.setImportado(rset.getString("Importado"));
                    requerimiento_3VO.setPrecio_Unidad(rset.getInt("Precio_Unidad"));
                    requerimiento_3VO.setCantidad(rset.getInt("Cantidad"));

                    respuesta.add(requerimiento_3VO);
                }
        }
        return respuesta;
    }
}