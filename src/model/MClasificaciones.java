package model;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MClasificaciones {
    
    private String clasificacionID;
    private String clasificacionNombre;
    private String clasificacionDescripcion;

    public MClasificaciones(String clasificacionID, String clasificacionNombre, String clasificacionDescripcion) {
        this.clasificacionID = clasificacionID;
        this.clasificacionNombre = clasificacionNombre;
        this.clasificacionDescripcion = clasificacionDescripcion;
    }

    public String getClasificacionID() {
        return clasificacionID;
    }
    public void setClasificacionID(String clasificacionID) {
        this.clasificacionID = clasificacionID;
    }

    public String getClasificacionNombre() {
        return clasificacionNombre;
    }
    public void setClasificacionNombre(String clasificacionNombre) {
        this.clasificacionNombre = clasificacionNombre;
    }

    public String getClasificacionDescripcion() {
        return clasificacionDescripcion;
    }
    public void setClasificacionDescripcion(String clasificacionDescripcion) {
        this.clasificacionDescripcion = clasificacionDescripcion;
    }
}
