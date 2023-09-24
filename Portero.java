/**
 * Esta clase es donde se crean los atributos del portero y su efectividad
 * 
 * @author: Dulce Ambrosio
 * @version: 23/09/2023
 */
public class Portero extends Jugador { // Se indica que hereda los atributos de la clase Jugador

    private int paradas_efectivas;
    private int goles_recibidos;

    /*
     * Class constructor
     */
    public Portero(String nombre, String pais, int faltas, int goles, int total_lanzamientos, int paradas_efectivas,
            int goles_recibidos) {
        super(nombre, pais, faltas, goles, total_lanzamientos);
        this.paradas_efectivas = paradas_efectivas;
        this.goles_recibidos = goles_recibidos;
    }

    /*
     * setters y getters
     */
    public int getParadas_efectivas() {
        return paradas_efectivas;
    }

    public void setParadas_efectivas(int paradas_efectivas) {
        this.paradas_efectivas = paradas_efectivas;
    }

    public int getGoles_recibidos() {
        return goles_recibidos;
    }

    public void setGoles_recibidos(int goles_recibidos) {
        this.goles_recibidos = goles_recibidos;
    }

    /**
     * Método para calcular la efectividad del portero, al momento de calcularse
     * puede dar
     * error por los datos ingresados que pueden ser 0 al momento de calcularse
     */

    public int efectividadPortero(int paradas_efectivas, int goles_recibidos, int goles, int total_lanzamientos) {
        return (((paradas_efectivas - goles_recibidos) * 100 / (paradas_efectivas + goles_recibidos))
                + (goles * 100) / total_lanzamientos);

    }

}