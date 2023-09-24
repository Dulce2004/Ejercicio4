/**
 * Esta clase es donde se crean los atributos que heredaran la clase Portero y
 * Extremo
 * 
 * @author: Dulce Ambrosio
 * @version: 23/09/2023
 */
public class Jugador {
    /**
     * Atributos que heredan la clase Portero y Extremo
     */
    protected String nombre;
    protected String pais;
    protected int faltas;
    protected int goles;
    protected int total_lanzamientos;

    /*
     * Class constructor
     */
    public Jugador(String nombre, String pais, int faltas, int goles, int total_lanzamientos) {
        this.nombre = nombre;
        this.pais = pais;
        this.faltas = faltas;
        this.goles = goles;
        this.total_lanzamientos = total_lanzamientos;
    }

    /*
     * setters y getters
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getTotal_lanzamientos() {
        return total_lanzamientos;
    }

    public void setTotal_lanzamientos(int total_lanzamientos) {
        this.total_lanzamientos = total_lanzamientos;
    }

}