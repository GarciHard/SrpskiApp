package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MClasificacionesDAO extends MConexion{
    
    private MClasificaciones clasificacionObj;
    private ArrayList<MClasificaciones> clasificacionArrObj;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String queryClasificaciones = "select upper(cla_id), cla_nombre,"
                                              + "cla_descripcion from clasificaciones";
    
    public ArrayList<MClasificaciones> clasificacionesArr() {
        clasificacionArrObj = new ArrayList<>();
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryClasificaciones);
            rs = ps.executeQuery();
            while ( rs.next() ) {
                clasificacionObj = new MClasificaciones(rs.getString(1),
                                                        rs.getString(2),
                                                        rs.getString(3));
                clasificacionArrObj.add(clasificacionObj); 
            }
            this.cerrar();
        } catch (Exception e) {
            System.out.println("listGen: "+e);
        }
        return clasificacionArrObj;
    }
    
    
}
