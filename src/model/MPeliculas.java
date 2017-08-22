package model;

/**
 * Hecho con <3 por: 
 * @author Alexis (GarciHard)
 */
public class MPeliculas {

    private String peliculaID;
    private String peliculaNombre;
    private String clasificacionID;
    private String generoID;
    private int peliculaDuracion;
    private String peliculaImagen;
    private char peliculaEstado;

    public MPeliculas(String peliculaNombre, String clasificacionID, String generoID, int peliculaDuracion, String peliculaImagen, char peliculaEstado) {
        this.peliculaNombre = peliculaNombre;
        this.clasificacionID = clasificacionID;
        this.generoID = generoID;
        this.peliculaDuracion = peliculaDuracion;
        this.peliculaImagen = peliculaImagen;
        this.peliculaEstado = peliculaEstado;
    }

    public MPeliculas(String peliculaID, String peliculaNombre, String generoID, String clasificacionID, int peliculaDuracion, String peliculaImagen, char peliculaEstado) {
        this.peliculaID = peliculaID;
        this.peliculaNombre = peliculaNombre;
        this.generoID = generoID;
        this.clasificacionID = clasificacionID;
        this.peliculaDuracion = peliculaDuracion;
        this.peliculaImagen = peliculaImagen;
        this.peliculaEstado = peliculaEstado;
    }

    public String getPeliculaID() {
        return peliculaID;
    }

    public void setPeliculaID(String peliculaID) {
        this.peliculaID = peliculaID;
    }

    public String getPeliculaNombre() {
        return peliculaNombre;
    }

    public void setPeliculaNombre(String peliculaNombre) {
        this.peliculaNombre = peliculaNombre;
    }

    public String getClasificacionID() {
        return clasificacionID;
    }

    public void setClasificacionID(String clasificacionID) {
        this.clasificacionID = clasificacionID;
    }

    public String getGeneroID() {
        return generoID;
    }

    public void setGeneroID(String generoID) {
        this.generoID = generoID;
    }

    public int getPeliculaDuracion() {
        return peliculaDuracion;
    }

    public void setPeliculaDuracion(int peliculaDuracion) {
        this.peliculaDuracion = peliculaDuracion;
    }

    public String getPeliculaImagen() {
        return peliculaImagen;
    }

    public void setPeliculaImagen(String peliculaImagen) {
        this.peliculaImagen = peliculaImagen;
    }

    public char getPeliculaEstado() {
        return peliculaEstado;
    }

    public void setPeliculaEstado(char peliculaEstado) {
        this.peliculaEstado = peliculaEstado;
    }

}
