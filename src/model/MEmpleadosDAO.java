package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 * Hecho con <3 por:
 * @author Alexis (GarciHard)
 */

public class MEmpleadosDAO extends MConexion {

    private DefaultTableModel dtm;
    private MEmpleados mEmpleados;
    private PreparedStatement ps;
    private ResultSet rs;
    private ResultSetMetaData nombreColumnas;
    private boolean mEmpCreateUpdate = false;
    private final String queryEmpCreate = "insert into empleados values ('EMP'||nvoEmpleado_seq.nextval,"
                                        + "initcap(?),initcap(?),initcap(?),initcap(?),?,initcap(?),initcap(?)"
                                        + ",initcap(?),?,?,initcap(?),?)";
    
    private final String queryEmpRead = "select upper(emp_id)ID, initcap(emp_nombre)NOMBRE,"
                                       +"initcap(emp_apellido_p)APELLIDOP, initcap(emp_apellido_m)APELLIDOM,"
                                       +"initcap(emp_cargo)CARGO from empleados";
    
    private final String queryEmpSearch = "select initcap(emp_nombre), initcap(emp_apellido_p),"
                                         +"initcap(emp_apellido_m), initcap(emp_calle), emp_numext,"
                                         +"initcap(emp_colonia), initcap(emp_municipio), initcap(emp_estado),"
                                         +"emp_numero, emp_foto, initcap(emp_cargo), emp_salario "
                                         +"from empleados where lower(emp_id) = ?";
    
    private final String queryEmpUpdate = "update empleados set "
                                          +"emp_nombre = initcap(?), emp_apellido_p = initcap(?), emp_apellido_m = initcap(?),"
                                          +"emp_calle = initcap(?), emp_numext = ?, emp_colonia = initcap(?), emp_municipio = initcap(?),"
                                          +"emp_estado = initcap(?), emp_numero = ?, emp_foto = ?, emp_cargo = initcap(?), emp_salario = ?"
                                          +"where lower(emp_id) = ?";
    
    private final String queryEmpDelSearch = "select initcap(emp_nombre)Nombre, initcap(emp_apellido_p||' '||emp_apellido_m)Apellidos,"
                                            +"initcap(emp_foto), initcap(emp_cargo),"
                                            +"emp_salario from empleados where lower(emp_id) = ?";
    private final String queryEmpDelete = "delete empleados where lower(emp_id) = ?";
    
    private final String queryEmpNvoID = 
    "select 'EMP'||max(substr(emp_id,4,length(emp_id))) from empleados "
                                        + "where length(substr(emp_id,4,length(emp_id))) > 1";
    
    public boolean DAOEmpCreate(MEmpleados mEmpleados) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryEmpCreate);
            ps.setString(1, mEmpleados.getEmpNombre());
            ps.setString(2, mEmpleados.getEmpApellidoP());
            ps.setString(3, mEmpleados.getEmpApellidoM());
            ps.setString(4, mEmpleados.getEmpCalle());
            ps.setInt(5, mEmpleados.getEmpNumExt());
            ps.setString(6, mEmpleados.getEmpColonia());
            ps.setString(7, mEmpleados.getEmpMunicipio());
            ps.setString(8, mEmpleados.getEmpEstado());
            ps.setLong(9, mEmpleados.getEmpNumero());
            ps.setString(10, mEmpleados.getEmpFoto());
            ps.setString(11, mEmpleados.getEmpCargo());
            ps.setInt(12, mEmpleados.getEmpSalario());

            ps.executeUpdate();
            mEmpCreateUpdate = true;
            this.cerrar();
        } catch (SQLException evt) {
            mEmpCreateUpdate = false;
            System.out.println("daoEmp" + evt);
        }
        return mEmpCreateUpdate;
    }
    
    public DefaultTableModel DAOEmpRead() {
        try {
            dtm = new DefaultTableModel();
            this.conectar();
            ps = this.conexion.prepareStatement(queryEmpRead);
            rs = ps.executeQuery();
            nombreColumnas = rs.getMetaData();
            int col = nombreColumnas.getColumnCount();
            String columName[] = new String[col];
            
            System.out.println("col:"+col);
            System.out.println(nombreColumnas.getColumnLabel(1));
            System.out.println(nombreColumnas.getColumnLabel(2));
            System.out.println(nombreColumnas.getColumnLabel(3));
            System.out.println(nombreColumnas.getColumnLabel(4));
            System.out.println(nombreColumnas.getColumnLabel(5));

            
            for (int i = 0; i < col; i++) {
                columName[i] = nombreColumnas.getColumnLabel(i+1);
                System.out.println(columName[i]);
            }
            
            dtm.setColumnIdentifiers(columName);
            
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("ID"), rs.getString("NOMBRE"), rs.getString("APELLIDOP"), rs.getString("APELLIDOM"), rs.getString("CARGO")});
            }
            this.cerrar();
        } catch (Exception e) {
        }
        return dtm;
    }

    public MEmpleados DAOEmpSearch(String empID) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryEmpSearch);
            ps.setString(1, empID);
            rs = ps.executeQuery();

            if (rs.next()) {
                mEmpleados = new MEmpleados(rs.getString(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5),
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getLong(9), rs.getString(10),
                        rs.getString(11), rs.getInt(12));
            }
            this.cerrar();
        } catch (Exception e) {
            System.out.println("exDAOSearch: " + e);
        }
        return mEmpleados;
    }

        public MEmpleados DAOEmpDelSearch(String empID) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryEmpDelSearch);
            ps.setString(1, empID);
            rs = ps.executeQuery();

            if (rs.next()) {
                mEmpleados = new MEmpleados(rs.getString(1), rs.getString(2),
                                            rs.getString(3), rs.getString(4),rs.getInt(5));
            }
            this.cerrar();
        } catch (Exception e) {
            System.out.println("exDAODelSearch: " + e);
        }
        return mEmpleados;
    }
    
    
    public boolean DAOEmpUpdate(MEmpleados mEmpleado) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryEmpUpdate);
            ps.setString(1, mEmpleado.getEmpNombre());
            ps.setString(2, mEmpleado.getEmpApellidoP());
            ps.setString(3, mEmpleado.getEmpApellidoM());
            ps.setString(4, mEmpleado.getEmpCalle());
            ps.setInt(5, mEmpleado.getEmpNumExt());
            ps.setString(6, mEmpleado.getEmpColonia());
            ps.setString(7, mEmpleado.getEmpMunicipio());
            ps.setString(8, mEmpleado.getEmpEstado());
            ps.setLong(9, mEmpleado.getEmpNumero());
            ps.setString(10, mEmpleado.getEmpFoto());
            ps.setString(11, mEmpleado.getEmpCargo());
            ps.setInt(12, mEmpleado.getEmpSalario());
            ps.setString(13, mEmpleado.getEmpID());
            ps.executeUpdate();
            mEmpCreateUpdate = true;
            this.cerrar();
        } catch (Exception evt) {
            mEmpCreateUpdate = false;
            System.out.println("DAOUpdt: "+evt);
        }
        return mEmpCreateUpdate;
    }
    
    public boolean DAOEmpDelete(String empID) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryEmpDelete);
            ps.setString(1, empID);
            ps.executeUpdate();
            this.cerrar();
            return true;
        } catch (Exception e) {
            System.out.println("daoDelete: "+e);
            return false;
        }
    }
    
    public String DAOEmpNvoID() {
        String ID = "";
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryEmpNvoID);
            rs = ps.executeQuery();
            if (rs.next()) {
                ID = rs.getString(1);
            }
            this.cerrar();
        } catch (Exception e) {
            System.out.println("ErrorID: "+e);
        }
        return ID;
    }
    
}
