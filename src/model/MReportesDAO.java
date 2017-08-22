package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MReportesDAO extends MConexion{
    
    private DefaultTableModel dtm;
    private PreparedStatement ps;
    private ResultSet rs;
    private ResultSetMetaData nombreColumnas;
    
    private String queryReporte1 = "create or replace view ventasPeliculas "
                                 + "as "
                                 + "select pel_nombre pelicula, count(bol_id)bolVendidos,sum(bol_precio)total " 
                                 + "from boletos b, funciones f, peliculas p "
                                 + "where b.fun_id = f.fun_id and f.pel_id = p.pel_id "
                                 + "group by pel_nombre";
    
    private String queryLeerRep1 = "select initcap(pelicula)pelicula,"
                                 + "bolVendidos, total "
                                 + "from ventasPeliculas "
                                 + "order by bolVendidos desc";
    
    //private String queryReporte2 = "{call ventasemp(?)}";
    private String queryReporte2 = "select emp_nombre nombre, count(bol_id)cantidad, sum(bol_precio)total "
            + "from empleados e "
            + "join boletos b "
            + "on e.emp_id = b.emp_id "
            + "join funciones f "
            + "on b.fun_id = f.fun_id "
            + "where to_char(f.FUN_FECHA,'MM') = ? "
            + "group by emp_nombre";
    private String queryLeerRep2 = "select initcap(nombre)nombre, cantidad, total "
            + "from ventasEmpleados "
            + "order by cantidad desc";
    
    private String queryReporte3 = "select count(bol_id)boletos, sum(bol_precio)total " +
"from boletos b " +
"join funciones f " +
"on (b.fun_id = f.fun_id) " +
"where to_char(f.FUN_FECHA, 'MM') = ?";
    
        public DefaultTableModel vistaVenta(String mes) {
        //crearVistaEmpleados(mes);
        try {
            dtm = new DefaultTableModel();
            this.conectar();
            ps = this.conexion.prepareStatement(queryReporte3);
            ps.setString(1, mes);
            rs = ps.executeQuery();
            nombreColumnas = rs.getMetaData();
            int col = nombreColumnas.getColumnCount();
            String columName[] = new String[col];

            System.out.println("col:" + col);

            for (int i = 0; i < col; i++) {
                columName[i] = nombreColumnas.getColumnLabel(i + 1);
                System.out.println(columName[i]);
            }

            dtm.setColumnIdentifiers(columName);

            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getInt("boletos"),rs.getInt("TOTAL")});
            }
            this.cerrar();
        } catch (Exception e) {
        }
        return dtm;
    }
    
    
    
    
    public void crearVistaEmpleados(String mes) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryReporte2);
            ps.setString(1, mes);
            ps.executeQuery();
        } catch (Exception e) {
            System.out.println("errorRep2: "+e);
        }
    }

    public DefaultTableModel vistaEmpleado(String mes) {
        //crearVistaEmpleados(mes);
        try {
            dtm = new DefaultTableModel();
            this.conectar();
            ps = this.conexion.prepareStatement(queryReporte2);
            ps.setString(1, mes);
            rs = ps.executeQuery();
            nombreColumnas = rs.getMetaData();
            int col = nombreColumnas.getColumnCount();
            String columName[] = new String[col];

            System.out.println("col:" + col);

            for (int i = 0; i < col; i++) {
                columName[i] = nombreColumnas.getColumnLabel(i + 1);
                System.out.println(columName[i]);
            }

            dtm.setColumnIdentifiers(columName);

            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("NOMBRE"), rs.getInt("CANTIDAD"), rs.getInt("TOTAL")});
            }
            this.cerrar();
        } catch (Exception e) {
        }
        return dtm;
    }
    
    public void crearVistaPeliculas() {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryReporte1);
            ps.executeQuery();
        } catch (Exception e) {
            System.out.println("errorVista1: "+e);
        }
    }
    
    public DefaultTableModel DAOEmpRead() {
        crearVistaPeliculas();
        try {
            dtm = new DefaultTableModel();
            this.conectar();
            ps = this.conexion.prepareStatement(queryLeerRep1);
            rs = ps.executeQuery();
            nombreColumnas = rs.getMetaData();
            int col = nombreColumnas.getColumnCount();
            String columName[] = new String[col];
            
            System.out.println("col:"+col);

            for (int i = 0; i < col; i++) {
                columName[i] = nombreColumnas.getColumnLabel(i+1);
                System.out.println(columName[i]);
            }
            
            dtm.setColumnIdentifiers(columName);
            
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("pelicula"), rs.getInt("bolVendidos"), rs.getInt("total")});
            }
            this.cerrar();
        } catch (Exception e) {
        }
        return dtm;
    }

}
