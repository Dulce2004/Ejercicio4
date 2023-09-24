
/*
 * Dulce Ambrosio - 231143, sección 20
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase es donde se crea la vista para el usuario, se llaman las otras
 * clases
 * 
 * @author: Dulce Ambrosio
 * @version: 023/09/2023
 */
public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Campeonato campeonato = new Campeonato(); // se crea el objeto del campeonato

        while (true) { // se crea el ciclo para el menú
            System.out.println("Bienvenido al Sitema");
            System.out.println("1. Ingresar Jugador");
            System.out.println("2. Mostrar a los jugadores registrados del campeonato");
            System.out.println("3. Mostrar a los tres mejores porteros");
            System.out.println("4. Cantidad de los jugadores extremos con más de 85% de efectividad");
            System.out.println("5. Salir");
            System.out.println("Ingrese el número de la opción que desee: ");

            int opcion = teclado.nextInt();

            switch (opcion) { // se crea el case
                case 1:

                    System.out.println("---Ingrese el tipo del jugador---");
                    System.out.println("1. Portero");
                    System.out.println("2. Extremo");

                    int opcion2 = teclado.nextInt();

                    if (opcion2 == 1) {
                        System.out.println("Ingrese los datos del jugador: ");
                        System.out.println("Nombre: ");
                        String nombre = teclado.nextLine();
                        System.out.println("País: ");
                        String pais = teclado.nextLine();
                        System.out.println("Cantidad de faltas: ");
                        int faltas = teclado.nextInt();
                        System.out.println("Cantidad de goles directos: ");
                        int goles = teclado.nextInt();
                        System.out.println("Total de lanzamientos: ");
                        int total_lanzamientos = teclado.nextInt();
                        System.out.println("Ingrese la cantidad de paradas efectivas: ");
                        int paradas_efectivas = teclado.nextInt();
                        System.out.println("Ingrese la cantidad de goles recibidos: ");
                        int goles_recibidos = teclado.nextInt();
                        Portero portero = new Portero(nombre, pais, faltas, goles, total_lanzamientos,
                                paradas_efectivas, goles_recibidos);
                        campeonato.jugadores.add(portero); // se agrega el jugador a la lista

                    } else if (opcion2 == 2) {
                        System.out.println("Ingrese los datos del jugador: ");
                        System.out.println("Nombre: ");
                        String nombre = teclado.nextLine();
                        System.out.println("País: ");
                        String pais = teclado.nextLine();
                        System.out.println("Cantidad de faltas: ");
                        int faltas = teclado.nextInt();
                        System.out.println("Cantidad de goles directos: ");
                        int goles = teclado.nextInt();
                        System.out.println("Total de lanzamientos: ");
                        int total_lanzamientos = teclado.nextInt();
                        System.out.println("Ingrese la canttidad de pases: ");
                        int pases = teclado.nextInt();
                        System.out.println("Ingrese la cantidad de asistencias efectivas");
                        int asistencias_efectivas = teclado.nextInt();
                        Extremo extremo = new Extremo(nombre, pais, faltas, goles, total_lanzamientos, pases,
                                asistencias_efectivas);
                        campeonato.jugadores.add(extremo); // se agrega el jugador a la lista
                    } else {
                        System.out.println("Ha Ingresado un número incorrecto");
                    }

                    break;
                case 2: // se imprimen los jugadores ingresados
                    for (Jugador jugador : campeonato.jugadores) {
                        System.out.println("Nombre: " + jugador.getNombre());
                        System.out.println("País: " + jugador.getPais());
                        System.out.println("Faltas: " + jugador.getFaltas());
                        System.out.println("Goles: " + jugador.getGoles());
                        System.out.println("Total de Lanzamientos: " + jugador.getTotal_lanzamientos());

                        if (jugador instanceof Portero) {
                            Portero portero = (Portero) jugador;
                            System.out.println("Paradas Efectivas: " + portero.getParadas_efectivas());
                            System.out.println("Goles Recibidos: " + portero.getGoles_recibidos());
                        } else if (jugador instanceof Extremo) {
                            Extremo extremo = (Extremo) jugador;
                            System.out.println("Pases: " + extremo.getPases());
                            System.out.println("Asistencias Efectivas: " + extremo.getAsistencias_efectivas());
                        }

                        System.out.println("-------------------");
                    }
                    break;
                case 3:
                    List<Portero> porteros = new ArrayList<>();
                    for (Jugador jugador : campeonato.jugadores) {
                        if (jugador instanceof Portero) {
                            Portero portero = (Portero) jugador;
                            porteros.add(portero);
                        }
                    }

                    // Ordenar la lista de porteros por efectividad
                    porteros.sort(Comparator.comparingInt(p -> p.efectividadPortero(
                            p.getParadas_efectivas(),
                            p.getGoles_recibidos(),
                            p.getGoles(),
                            p.getTotal_lanzamientos())));
                    // Mostrar los tres mejores porteros
                    System.out.println("Los tres mejores porteros son:");
                    for (int i = 0; i < Math.min(3, porteros.size()); i++) {
                        Portero portero = porteros.get(i);
                        System.out.println("Nombre: " + portero.getNombre());
                        System.out.println("País: " + portero.getPais());
                        System.out.println("Efectividad: " + portero.efectividadPortero(i, i, opcion, i));
                        System.out.println("-------------------");
                    }
                    break;
                case 4:
                    int extremosConEfectividadMayor85 = 0;
                    for (Jugador jugador : campeonato.jugadores) {
                        if (jugador instanceof Extremo) {
                            Extremo extremo = (Extremo) jugador;
                            int efectividad = extremo.efectividadExtremo();
                            if (efectividad > 85) {
                                extremosConEfectividadMayor85++;
                            }
                        }
                    }
                    System.out.println("Cantidad de jugadores extremos con efectividad mayor al 85%: "
                            + extremosConEfectividadMayor85);
                    break;
                case 5:
                    System.out.println("Cerrando Sistema...");
                    teclado.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 5.");
                    break;
            }

        }

    }
}