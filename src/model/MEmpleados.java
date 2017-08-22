package model;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MEmpleados {

    private String empID;
    private String empNombre;
    private String empApellidoP;
    private String empApellidoM;
    private String empCalle;
    private int empNumExt;
    private String empColonia;
    private String empMunicipio;
    private String empEstado;
    private long empNumero;
    private String empFoto;
    private String empCargo;
    private int empSalario;
    
    public MEmpleados(String empID, String empNombre, String empApellidoP, String empApellidoM, String empCalle, int empNumExt, String empColonia, String empMunicipio, String empEstado, long empNumero, String empFoto, String empCargo, int empSalario) {
        this.empID = empID;
        this.empNombre = empNombre;
        this.empApellidoP = empApellidoP;
        this.empApellidoM = empApellidoM;
        this.empCalle = empCalle;
        this.empNumExt = empNumExt;
        this.empColonia = empColonia;
        this.empMunicipio = empMunicipio;
        this.empEstado = empEstado;
        this.empNumero = empNumero;
        this.empFoto = empFoto;
        this.empCargo = empCargo;
        this.empSalario = empSalario;
    }

    public MEmpleados(String empNombre, String empApellidoP, String empApellidoM, String empCalle, int empNumExt, String empColonia, String empMunicipio, String empEstado, long empNumero, String empFoto, String empCargo, int empSalario) {
        this.empNombre = empNombre;
        this.empApellidoP = empApellidoP;
        this.empApellidoM = empApellidoM;
        this.empCalle = empCalle;
        this.empNumExt = empNumExt;
        this.empColonia = empColonia;
        this.empMunicipio = empMunicipio;
        this.empEstado = empEstado;
        this.empNumero = empNumero;
        this.empFoto = empFoto;
        this.empCargo = empCargo;
        this.empSalario = empSalario;
    }
    
    public MEmpleados(String empNombre, String empApellidoP, String empFoto, String empID) {
        this.empNombre = empNombre;
        this.empApellidoP = empApellidoP;
        this.empFoto = empFoto;
        this.empID = empID;
    }

    public MEmpleados(String empNombre, String empApellidoP, String empFoto, String empCargo, int empSalario) {
        this.empNombre = empNombre;
        this.empApellidoP = empApellidoP;
        this.empFoto = empFoto;
        this.empCargo = empCargo;
        this.empSalario = empSalario;
    }
    
    public String getEmpID() {
        return empID;
    }
    public void setEmpID(String empID) {
        this.empID = empID;
    }
    public String getEmpNombre() {
        return empNombre;
    }
    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }
    public String getEmpApellidoP() {
        return empApellidoP;
    }
    public void setEmpApellidoP(String empApellidoP) {
        this.empApellidoP = empApellidoP;
    }
    public String getEmpApellidoM() {
        return empApellidoM;
    }
    public void setEmpApellidoM(String empApellidoM) {
        this.empApellidoM = empApellidoM;
    }
    public String getEmpCalle() {
        return empCalle;
    }
    public void setEmpCalle(String empCalle) {
        this.empCalle = empCalle;
    }
    public int getEmpNumExt() {
        return empNumExt;
    }
    public void setEmpNumExt(int empNumExt) {
        this.empNumExt = empNumExt;
    }
    public String getEmpColonia() {
        return empColonia;
    }
    public void setEmpColonia(String empColonia) {
        this.empColonia = empColonia;
    }
    public String getEmpMunicipio() {
        return empMunicipio;
    }
    public void setEmpMunicipio(String empMunicipio) {
        this.empMunicipio = empMunicipio;
    }
    public String getEmpEstado() {
        return empEstado;
    }
    public void setEmpEstado(String empEstado) {
        this.empEstado = empEstado;
    }
    public long getEmpNumero() {
        return empNumero;
    }
    public void setEmpNumero(long empNumero) {
        this.empNumero = empNumero;
    }
    public String getEmpFoto() {
        return empFoto;
    }
    public void setEmpFoto(String empFoto) {
        this.empFoto = empFoto;
    }
    public String getEmpCargo() {
        return empCargo;
    }
    public void setEmpCargo(String empCargo) {
        this.empCargo = empCargo;
    }
    public int getEmpSalario() {
        return empSalario;
    }
    public void setEmpSalario(int empSalario) {
        this.empSalario = empSalario;
    }
}
