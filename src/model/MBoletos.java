package model;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MBoletos {
    private String bolID;
    private String funID;
    private String empID;
    private String cteID;
    private String bolNombre;
    private int bolPrecio;
    private char bolFila;
    private int bolAsiento;

    public MBoletos(String bolID, String funID, String empID, String cteID, String bolNombre, int bolPrecio) {
        this.bolID = bolID;
        this.funID = funID;
        this.empID = empID;
        this.cteID = cteID;
        this.bolNombre = bolNombre;
        this.bolPrecio = bolPrecio;
    }

    public MBoletos(String funID, String empID, String cteID, String bolNombre, int bolPrecio) {
        this.funID = funID;
        this.empID = empID;
        this.cteID = cteID;
        this.bolNombre = bolNombre;
        this.bolPrecio = bolPrecio;
    }
    
    
    
    public MBoletos(String bolID, String funID, String empID, String cteID, String bolNombre, int bolPrecio, char bolFila, int bolAsiento) {
        this.bolID = bolID;
        this.funID = funID;
        this.empID = empID;
        this.cteID = cteID;
        this.bolNombre = bolNombre;
        this.bolPrecio = bolPrecio;
        this.bolFila = bolFila;
        this.bolAsiento = bolAsiento;
    }

    public String getBolID() {
        return bolID;
    }

    public void setBolID(String bolID) {
        this.bolID = bolID;
    }

    public String getFunID() {
        return funID;
    }

    public void setFunID(String funID) {
        this.funID = funID;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getCteID() {
        return cteID;
    }

    public void setCteID(String cteID) {
        this.cteID = cteID;
    }

    public String getBolNombre() {
        return bolNombre;
    }

    public void setBolNombre(String bolNombre) {
        this.bolNombre = bolNombre;
    }

    public int getBolPrecio() {
        return bolPrecio;
    }

    public void setBolPrecio(int bolPrecio) {
        this.bolPrecio = bolPrecio;
    }

    public char getBolFila() {
        return bolFila;
    }

    public void setBolFila(char bolFila) {
        this.bolFila = bolFila;
    }

    public int getBolAsiento() {
        return bolAsiento;
    }

    public void setBolAsiento(int bolAsiento) {
        this.bolAsiento = bolAsiento;
    }
    
}
