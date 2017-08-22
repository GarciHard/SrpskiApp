package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MGenerosDAO extends MConexion{
    
    private MGeneros generoObj;
    private ArrayList<MGeneros> generosArrObj;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String queryGeneros = "select gen_id, initcap(gen_nombre) "
                                      + "from generos";
    
    public ArrayList<MGeneros> generosArr() {
        generosArrObj = new ArrayList<>();
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryGeneros);
            rs = ps.executeQuery();
            while ( rs.next() ) {
                generoObj = new MGeneros(rs.getString(1), rs.getString(2));
                generosArrObj.add(generoObj); 
            }
            this.cerrar();
        } catch (Exception e) {
            System.out.println("listGen: "+e);
        }
        return generosArrObj;
    }
    
}
