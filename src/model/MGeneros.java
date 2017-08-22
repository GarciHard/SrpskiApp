package model;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MGeneros {
    
    private String generoID;
    private String generoNombre;
    
    
    public MGeneros (String generoID, String generoNombre) {
        this.generoID = generoID;
        this.generoNombre = generoNombre;
    }
    
    public void setGeneroID(String generoID) {
        this.generoID = generoID;
    }
    public String getGeneroID() {
        return generoID;
    }
    
    public void setGeneroNombre(String generoNombre) {
        this.generoNombre = generoNombre;
    }
    public String getGeneroNombre() {
        return generoNombre;
    }
    
    
}
