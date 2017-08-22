package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MFuncionesDAO extends MConexion{
    private ArrayList<MFunciones> funcionesArr;
    private MFunciones funcObj;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private String queryFuncionesInfo = "select upper(fun_id), initcap(pel_nombre), fun_hora_ini " +
                                        "from peliculas p " +
                                        "join funciones f " +
                                        "on(p.pel_id = f.pel_id) " +
                                        "where to_char(fun_fecha,'DD/MM/YYYY') = ? " +
                                        "order by fun_hora_ini";
    
    private String queryFuncionesHora = "select fun_id, pel_nombre, fun_hora_ini " +
                                        "from peliculas p " +
                                        "join funciones f " +
                                        "on(p.pel_id = f.pel_id) " +
                                        "where to_char(fun_fecha,'DD/MM/YYYY') = ? " +
                                        "and lower(pel_nombre) = ? ";
    
    private String queryFuncionesImg = "select fun_id, pel_nombre, fun_hora_ini, pel_img " +
                                        "from peliculas p " +
                                        "join funciones f " +
                                        "on(p.pel_id = f.pel_id) " +
                                        "where to_char(fun_fecha,'DD/MM/YYYY') = ? " +
                                        "and lower(pel_nombre) = ? ";
    
    private String queryFuncionesID = "select fun_id, pel_nombre, fun_hora_ini, pel_img " +
                                        "from peliculas p " +
                                        "join funciones f " +
                                        "on(p.pel_id = f.pel_id) " +
                                        "where to_char(fun_fecha,'DD/MM/YYYY') = ? " +
                                        "and lower(pel_nombre) = ? ";
    
    private String queryFuncionesSal = "select sal_id " +
                                        "from peliculas p " +
                                        "join funciones f " +
                                        "on(p.pel_id = f.pel_id) " +
                                        "where to_char(fun_fecha,'DD/MM/YYYY') = ? " +
                                        "and lower(pel_nombre) = ? ";
    
    private String queryFuncionesBolDisponibles = "select s.sal_capacidad - count(b.bol_id) " +
                                                  "from boletos b " +
                                                  "join funciones f " +
                                                  "on(b.fun_id = f.fun_id) " +
                                                  "join salas s " +
                                                  "on (f.sal_id = s.sal_id) " +
                                                  "where b.fun_id = ? " +
                                                  "group by sal_capacidad";
    
    public ArrayList<MFunciones> funcionesArr(String fechaIni) {
        funcionesArr = new ArrayList<>();
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryFuncionesInfo);
            ps.setString(1, fechaIni);
            rs = ps.executeQuery();
            while (rs.next()) {
                funcObj = new MFunciones(rs.getString(1), rs.getString(2), rs.getString(3));
                funcionesArr.add(funcObj);
            }
            this.cerrar();
        } catch (Exception e) {
            System.out.println("FuncionesArr: "+e);
        }
        return funcionesArr;
    }
    
    public String funcionesHora(String fechaIni, String pelNombre) {
        String horaPelicula ="";
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryFuncionesHora);
            ps.setString(1, fechaIni);
            ps.setString(2, pelNombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                horaPelicula = rs.getString(3);
            }
            
        } catch (Exception e) {
            System.out.println("FuncionesHora: "+e);
        }
        return horaPelicula;
    }
    
    public String funcionesIMG(String fechaIni, String pelNombre) {
        String imgPelicula ="";
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryFuncionesImg);
            ps.setString(1, fechaIni);
            ps.setString(2, pelNombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                imgPelicula = rs.getString(4);
            }
            
        } catch (Exception e) {
            System.out.println("FuncionesIMG: "+e);
        }
        return imgPelicula;
    }
    
    public String funcionesID(String fechaIni, String pelNombre) {
        String idPelicula ="";
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryFuncionesID);
            ps.setString(1, fechaIni);
            ps.setString(2, pelNombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                idPelicula = rs.getString(1);
            }
            
        } catch (Exception e) {
            System.out.println("FuncionesID: "+e);
        }
        return idPelicula;
    }
    
    public String funSala(String fechaIni, String pelNombre) {
        String idSala ="";
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryFuncionesSal);
            ps.setString(1, fechaIni);
            ps.setString(2, pelNombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                idSala = rs.getString(1);
            }
            
        } catch (Exception e) {
            System.out.println("FuncionesID: "+e);
        }
        return idSala;
    }
    
    public String funcionesBolDisponibles(String funID) {
        String bolDisponibles ="";
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryFuncionesBolDisponibles);
            ps.setString(1, funID);
            rs = ps.executeQuery();
            if (rs.next()) {
                bolDisponibles = rs.getString(1);
            }
            
        } catch (Exception e) {
            System.out.println("FuncBolDisponibles: "+e);
        }
        return bolDisponibles;
    }
}
