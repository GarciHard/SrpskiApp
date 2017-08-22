package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MPeliculasDAO extends MConexion {
    
    private DefaultTableModel dtm;
    private MPeliculas peliculaObj;
    private PreparedStatement ps;
    private ResultSet rs;
    private ResultSetMetaData nombreColumnas;
    private final String queryCreatePel = "insert into peliculas(pel_id, pel_nombre, gen_id,"
                                        + "cla_id, pel_duracion, pel_img, pel_estado) "
                                        + "values('PEL'||nvoPelicula_seq.nextval,initcap(?),?,?,?,?,?)";
    
    private final String queryReadPel = "select upper(pel_id)ID, "
                                      + "initcap(pel_nombre)Nombre, "
                                      + "initcap(gen_nombre)Genero, "
                                      + "upper(case pel_estado when 'V' "
                                      + "then 'activa' when 'F' then 'inactiva' end)Estado "
                                      + "from peliculas f "
                                      + "inner join generos g "
                                      + "on (f.gen_id = g.gen_id) order by pel_id";
    
    private final String queryFindPel = "select upper(pel_id), initcap(pel_nombre), "
                                        + "initcap(gen_nombre), upper(cla_id), pel_duracion, "
                                        + "pel_img, pel_estado "
                                        + "from peliculas p "
                                        + "inner join generos g "
                                        + "on (p.gen_id = g.gen_id) "
                                        + "where upper(pel_id) = ?";
    
    private final String queryUpdatePel = "update peliculas "
                                        + "set pel_nombre = initcap(?), gen_id = ?, cla_id = ?,"
                                        + "pel_duracion = ?, pel_img =?, pel_estado = ? "
                                        + "where upper(pel_id) = ?";
    
    private final String queryDeletePel = "delete peliculas "
                                        + "where upper(pel_id) = ?";
    
    private final String queryNvoPelID =  "select 'PEL'||max(substr(pel_id,4,length(pel_id))) from peliculas "
                                        + "where length(substr(pel_id,4,length(pel_id))) > 1";
    
    public boolean createPelicula(MPeliculas peliculaObj) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryCreatePel);
            ps.setString(1, peliculaObj.getPeliculaNombre());
            ps.setString(2, peliculaObj.getGeneroID());
            ps.setString(3, peliculaObj.getClasificacionID());
            ps.setInt(4, peliculaObj.getPeliculaDuracion());
            ps.setString(5, peliculaObj.getPeliculaImagen());
            ps.setString(6, String.valueOf(peliculaObj.getPeliculaEstado()));
            ps.executeUpdate();
            this.cerrar();
            return true;
        } catch(Exception e) {
            System.out.println("PeliAdd: "+e);
            return false;
        }
    }
    
    public DefaultTableModel readPelicula() {
        try {
            dtm = new DefaultTableModel();
            this.conectar();
            ps = this.conexion.prepareStatement(queryReadPel);
            rs = ps.executeQuery();
            nombreColumnas = rs.getMetaData();
            int col = nombreColumnas.getColumnCount();
            String columName[] = new String[col];
            
            System.out.println("col:"+col);
            System.out.println(nombreColumnas.getColumnLabel(1));
            System.out.println(nombreColumnas.getColumnLabel(2));
            System.out.println(nombreColumnas.getColumnLabel(3));

            
            for (int i = 0; i < col; i++) {
                columName[i] = nombreColumnas.getColumnLabel(i+1);
                System.out.println(columName[i]);
            }
            
            dtm.setColumnIdentifiers(columName);
            
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString("ID"), rs.getString("Nombre"),rs.getString("Genero"), rs.getString("Estado")});
            }
            this.cerrar();
        } catch (Exception e) {
        }
        return dtm;
    }
    
    public MPeliculas findPeliculas(String pelID) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryFindPel);
            ps.setString(1, pelID);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                peliculaObj = new MPeliculas(rs.getString(1),rs.getString(2),
                                             rs.getString(3),rs.getString(4),
                                             rs.getInt(5),rs.getString(6),
                                             rs.getString(7).charAt(0));
            }
            this.cerrar();
        } catch (Exception e) {
            System.out.println("findPel: "+e);
        }
        return peliculaObj;
    }
    
        public boolean updatePelicula(MPeliculas peliculaObj) {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryUpdatePel);

            ps.setString(1, peliculaObj.getPeliculaNombre());
            ps.setString(2, peliculaObj.getGeneroID());
            ps.setString(3, peliculaObj.getClasificacionID());
            ps.setInt(4, peliculaObj.getPeliculaDuracion());
            ps.setString(5, peliculaObj.getPeliculaImagen());
            ps.setString(6, String.valueOf(peliculaObj.getPeliculaEstado()));
            ps.setString(7, peliculaObj.getPeliculaID());
            ps.executeUpdate();
            this.cerrar();
            return true;
        } catch(Exception e) {
            System.out.println("PeliUpd: "+e);
            return false;
        }
    }
        
        public boolean deletePelicula(String pelID) {
            try {
                this.conectar();
                ps = this.conexion.prepareStatement(queryDeletePel);
                ps.setString(1, pelID);
                ps.executeUpdate();
                this.cerrar();
                return true;
            } catch (Exception e) {
                System.out.println("deletePel: "+e);
                return false;
            }
        }

    public String nvoPeliculaID() {
        String ID = "";
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(queryNvoPelID);
            rs = ps.executeQuery();
            if (rs.next()) {
                ID = rs.getString(1);
            }
            this.cerrar();
        } catch (Exception e) {
            System.out.println("ErrorID: " + e);
        }
        return ID;
    }
}
