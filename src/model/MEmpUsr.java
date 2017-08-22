package model;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MEmpUsr {
    
    private String empUsrNombre;
    private String empUsrApellidos;
    private String empUsrFoto;
    private String empUsrCargo;
    private String empUsrUsuario;
    private String empUsrPasswd;

    public MEmpUsr() {
    }

    public MEmpUsr(String empUsrNombre, String empUsrApellidos, String empUsrFoto, String empUsrCargo) {
        this.empUsrNombre = empUsrNombre;
        this.empUsrApellidos = empUsrApellidos;
        this.empUsrFoto = empUsrFoto;
        this.empUsrCargo = empUsrCargo;
    }

    public MEmpUsr(String empUsrNombre, String empUsrApellidos, String empUsrFoto, String empUsrCargo, String empUsrUsuario) {
        this.empUsrNombre = empUsrNombre;
        this.empUsrApellidos = empUsrApellidos;
        this.empUsrFoto = empUsrFoto;
        this.empUsrCargo = empUsrCargo;
        this.empUsrUsuario = empUsrUsuario;
    }

    public String getEmpUsrNombre() {
        return empUsrNombre;
    }

    public void setEmpUsrNombre(String empUsrNombre) {
        this.empUsrNombre = empUsrNombre;
    }

    public String getEmpUsrApellidos() {
        return empUsrApellidos;
    }

    public void setEmpUsrApellidos(String empUsrApellidos) {
        this.empUsrApellidos = empUsrApellidos;
    }

    public String getEmpUsrFoto() {
        return empUsrFoto;
    }

    public void setEmpUsrFoto(String empUsrFoto) {
        this.empUsrFoto = empUsrFoto;
    }

    public String getEmpUsrUsuario() {
        return empUsrUsuario;
    }

    public void setEmpUsrUsuario(String empUsrUsuario) {
        this.empUsrUsuario = empUsrUsuario;
    }

    public String getEmpUsrPasswd() {
        return empUsrPasswd;
    }

    public void setEmpUsrPasswd(String empUsrPasswd) {
        this.empUsrPasswd = empUsrPasswd;
    }

    public String getEmpUsrCargo() {
        return empUsrCargo;
    }

    public void setEmpUsrCargo(String empUsrCargo) {
        this.empUsrCargo = empUsrCargo;
    }
}
