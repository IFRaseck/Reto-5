package utp.misiontic2022.c2.p51.reto4.modelo.vo;

public class Requerimiento_1 {
    private String nombre_Material;
    private Integer precio_Unidad;

    public String getNombreMaterial(){
        return nombre_Material;
    }
    public void setNombreMaterial(String nombre_Material){
        this.nombre_Material = nombre_Material;
    }

    public Integer getPrecioUnidad(){
        return precio_Unidad;
    }
    public void setPrecioUnidad(Integer precio_Unidad){
        this.precio_Unidad = precio_Unidad;
    }
}