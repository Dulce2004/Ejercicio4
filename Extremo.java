/**
 * Esta clase es donde se crean los atributos del extremo y su efectividad
 * 
 * @author: Dulce Ambrosio
 * @version: 23/09/2023
 */
public class Extremo extends Jugador { // Se indica que hereda los atributos de la clase Jugador

    private int pases;
    private int asistencias_efectivas;

    /*
     * Class constructor
     */
    public Extremo(String nombre, String pais, int faltas, int goles, int total_lanzamientos, int pases,
            int asistencias_efectivas) {
        super(nombre, pais, faltas, goles, total_lanzamientos);
        this.pases = pases;
        this.asistencias_efectivas = asistencias_efectivas;
    }

    /*
     * setters y getters
     */
    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getAsistencias_efectivas() {
        return asistencias_efectivas;
    }

    public void setAsistencias_efectivas(int asistencias_efectivas) {
        this.asistencias_efectivas = asistencias_efectivas;
    }

    /**
     * Método para calcular la efectividad del extremo, al momento de calcularse
     * puede dar
     * error por los datos ingresados que pueden ser 0 al momento de calcularse
     */
    public int efectividadExtremo() {
        return (((pases + asistencias_efectivas - faltas) * 10 / (pases + asistencias_efectivas + faltas))
                + (goles * 100) / total_lanzamientos);
    }

}