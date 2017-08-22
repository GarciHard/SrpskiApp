package model;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MFunciones {
    private String funId;
    private String salID;
    private String pelID;
    private String funFecha;
    private String funHoraIni;

    public MFunciones(String funId, String salID, String pelID, String funFecha, String funHoraIni) {
        this.funId = funId;
        this.salID = salID;
        this.pelID = pelID;
        this.funFecha = funFecha;
        this.funHoraIni = funHoraIni;
    }

    public MFunciones(String funId, String pelID, String funHoraIni) {
        this.funId = funId;
        this.pelID = pelID;
        this.funHoraIni = funHoraIni;
    }

    public String getFunId() {
        return funId;
    }

    public void setFunId(String funId) {
        this.funId = funId;
    }

    public String getSalID() {
        return salID;
    }

    public void setSalID(String salID) {
        this.salID = salID;
    }

    public String getPelID() {
        return pelID;
    }

    public void setPelID(String pelID) {
        this.pelID = pelID;
    }

    public String getFunFecha() {
        return funFecha;
    }

    public void setFunFecha(String funFecha) {
        this.funFecha = funFecha;
    }

    public String getFunHoraIni() {
        return funHoraIni;
    }

    public void setFunHoraIni(String funHoraIni) {
        this.funHoraIni = funHoraIni;
    }
    
}
