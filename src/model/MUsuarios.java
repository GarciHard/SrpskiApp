package model;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MUsuarios {

    private String empID;
    private String usrUsuario;
    private String usrPasswd;

    public MUsuarios() {
    }
    
    public MUsuarios(String empID, String usrUsuario, String usrPasswd) {
        this.empID = empID;
        this.usrUsuario = usrUsuario;
        this.usrPasswd = usrPasswd;
    }
    
    public MUsuarios(String usrUsuario, String usrPasswd) {
        this.usrUsuario = usrUsuario;
        this.usrPasswd = usrPasswd;
    }

    
    public String getEmpID() {
        return empID;
    }
    public void setEmpID(String empID) {
        this.empID = empID;
    }
    public String getUsrUsuario() {
        return usrUsuario;
    }
    public void setUsrUsuario(String usrUsuario) {
        this.usrUsuario = usrUsuario;
    }
    public String getUsrPasswd() {
        return usrPasswd;
    }
    public void setUsrPasswd(String usrPasswd) {
        this.usrPasswd = usrPasswd;
    }
    
}
