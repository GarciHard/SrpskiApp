package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Hecho con <3 por:
 * @author Alexis (GarciHard)
 */
public class MUsuariosDAO extends MConexion {
    
    private MEmpUsr empUsr;
    private MEmpleados datosEmpleado;
    private PreparedStatement ps;
    private ResultSet rs;
    private final String queryEmpDatos = "select initcap(e.emp_nombre), initcap(e.emp_apellido_p), e.emp_foto, upper(e.emp_id) from empleados e join usuarios u on (e.emp_id = u.emp_id) where lower(u.usr_usuario) = ? and lower(u.usr_passwd) = ?";
    private final String queryCargo = "select initcap(emp_cargo) from empleados e join usuarios u on (e.emp_id = u.emp_id) where lower(usr_usuario) = ? and lower(usr_passwd) = ?";
    private String cargoEmpleado = "";
    
    private final String queryEmpUsrDatosCargo = "select initcap(emp_nombre),"
            + "initcap(emp_apellido_p||' '||emp_apellido_m), initcap(emp_foto),"
            + "initcap(emp_cargo) "
            + "from empleados "
            + "where lower(emp_id) = ?";
    
    private final String queryTieneUsuario = "select usr_usuario "
                                           + "from usuarios "
                                           + "where lower(emp_id) = ?";
    
    private final String queryUsrCreate = "insert into usuarios(emp_id,usr_usuario,usr_passwd) "
                                        + "values (?,?,?)";

    public String cargoEmpleado(MUsuarios usuarioVO) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryCargo);
            ps.setString(1, usuarioVO.getUsrUsuario());
            ps.setString(2, usuarioVO.getUsrPasswd());
            rs = ps.executeQuery();
            if (rs.next()) {
                cargoEmpleado = rs.getString(1);
            } else {
                cargoEmpleado = "sin empleo";
            }
            this.cerrar();
        } catch (Exception e) {
        }
        return cargoEmpleado;
    }

    public MEmpleados datosEmpleado(MUsuarios usuarioVO) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryEmpDatos);
            ps.setString(1, usuarioVO.getUsrUsuario());
            ps.setString(2, usuarioVO.getUsrPasswd());
            rs = ps.executeQuery();
            if (rs.next()) {
                datosEmpleado = new MEmpleados(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            this.cerrar();
        } catch (Exception e) {
        }
        return datosEmpleado;
    }
    
    /*UI CrearUsuario*/
    public MEmpUsr datosCargo(String empID) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryTieneUsuario);
            ps.setString(1, empID);
            rs = ps.executeQuery();

            if (rs.next()) { //tiene usuario
                empUsr = new MEmpUsr("", "", "", "", rs.getString(1));
                rs.close();
                ps.close();
            } else { //no tiene usuario
                try {
                    ps = this.conexion.prepareStatement(queryEmpUsrDatosCargo);
                    ps.setString(1, empID);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        empUsr = new MEmpUsr(rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getString(4), "");
                    }
                } catch (Exception e) {
                    System.out.println("tryAnidado: " + e);
                }
            }
            System.out.println("nombre: " + empUsr.getEmpUsrNombre());
            System.out.println("apellidos: " + empUsr.getEmpUsrApellidos());
            System.out.println("cargo: " + empUsr.getEmpUsrCargo());
            System.out.println("usr: " + empUsr.getEmpUsrUsuario());
            this.cerrar();
        } catch (Exception e) {
            System.out.println("datosCargo: " + e);
        }
        return empUsr;
    }
    
    public boolean crearUsuario(MUsuarios usuarioVO) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryUsrCreate);
            ps.setString(1, usuarioVO.getEmpID());
            ps.setString(2, usuarioVO.getUsrUsuario());
            ps.setString(3, usuarioVO.getUsrPasswd());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("crearUsuario: " + e);
            return false;
        }
    }
}
