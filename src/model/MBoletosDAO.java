package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MBoletosDAO extends MConexion{
    
    private PreparedStatement ps;
    private ResultSet rs;
    private MBoletos bolObj;
    private CallableStatement cst;
    
    private String queryBolCreate = "insert into boletos "
                                  + "values('BOL'||nvoBoleto_seq.nextval,?,?,?,?,?)";
    
    private String queryNvoCte = "select 'CTE'||max(substr(cte_id,4,length(cte_id))) "+
                                 "from clientes " +
                                 "where length(substr(cte_id,4,length(cte_id))) > 1";
    
    private String queryBoletosCrear = "{call boletosCtes(?,?,?,?,?)}";
    
    
    public boolean createBol(int cantidad, String funID, String empID, String bolNom, int bolPre) {
        try {
            this.conectar();
            cst = this.conexion.prepareCall(queryBoletosCrear);
            cst.setInt(1, cantidad);
            cst.setString(2, funID);
            cst.setString(3, empID);
            cst.setString(4, bolNom);
            cst.setInt(5, bolPre);
            cst.execute();
            return true;
        } catch (Exception e) {
            System.out.println("errorProcedure: "+e);
            return false;
        }
    }

    public boolean bolCreate(MBoletos bolObj) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryBolCreate);
            ps.setString(1,bolObj.getFunID());
            ps.setString(2,bolObj.getEmpID());
            ps.setString(3,bolObj.getCteID());
            ps.setString(4,bolObj.getBolNombre());
            ps.setInt(5,bolObj.getBolPrecio());
            ps.executeUpdate();
            this.cerrar();
            return true;
        } catch (Exception e) {
            System.out.println("bolCreate: "+e);
            return false;
        }
    }
    
    public String nvoPeliculaID() {
        String ID = "";
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryNvoCte);
            rs = ps.executeQuery();
            if (rs.next()) {
                ID = rs.getString(1);
            }
            this.cerrar();
        } catch (Exception e) {
            System.out.println("ErrorIDCte: " + e);
        }
        return ID;
    }
    
}
