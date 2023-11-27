package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Objects;

public class Consola {
    private Consola() {

    }

    public static void mostrarMenuPrincipal() {
        System.out.println("Menú de Acciones.");
        System.out.println("(1) Crear un robot por defecto.");
        System.out.println("(2) Crear un robot Indicando su zona.");
        System.out.println("(3) Crear un robot Indicando su zona y orientación.");
        System.out.println("(4) Crear un robot Indicando su zona, orientación y coordenada Inicial.");
        System.out.println("(5) Ejecutar Opción.");
        System.out.println("(6) Salir.");
    }

    public static int elegirOpccion() {
        int opcionElegida;
        System.out.print("Elige una Opción: ");
        opcionElegida = Entrada.entero();
        switch (opcionElegida) {
            case 1 -> System.out.println("Has elegido la opción 1.");
            case 2 -> System.out.println("Has elegido la opción 2.");
            case 3 -> System.out.println("Has elegido la opción 3.");
            case 4 -> System.out.println("Has elegido la opción 4.");
            case 5 -> System.out.println("Has elegido la opción 5.");
            case 6 -> System.out.println("Has elegido la opción 6.");
            default -> System.out.println("Opción no válida.");
        }
        return opcionElegida;
    }

    public static Zona elegirZona() {
        int zonaAncho;
        int zonaAlto;
        do {
            try {
                System.out.print("Elige el Ancho de la Zona: ");
                zonaAncho = Entrada.entero();
                System.out.print("Elige el Alto de la Zona: ");
                zonaAlto = Entrada.entero();

                // Lanzar excepciones de Zona si es necesario
                new Zona(zonaAncho, zonaAlto);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                zonaAncho = zonaAlto = 0; // Reiniciar valores para repetir el bucle
            }

        } while (zonaAncho <= 0 || zonaAlto <= 0);
        return new Zona(zonaAncho, zonaAlto);
    }

    public static void mostrarMenuOrientacion() {
        System.out.println("Menú de la Orientación.");
        System.out.println("(1) Norte.");
        System.out.println("(2) Noreste.");
        System.out.println("(3) Este.");
        System.out.println("(4) Sureste.");
        System.out.println("(5) Sur.");
        System.out.println("(6) Suroeste.");
        System.out.println("(7) Oeste.");
        System.out.println("(8) Noroeste.");
    }

    public static Orientacion elegirOrientacion() {
        int orientacionElegida;
        System.out.println("Elige una Orientación: ");
        orientacionElegida = Entrada.entero();

        switch (orientacionElegida) {
            case 1 -> {
                System.out.println("Has elegido la opción 1.");
                return Orientacion.NORTE;
            }

            case 2 -> {
                System.out.println("Has elegido la opción 2.");
                return Orientacion.NORESTE;
            }

            case 3 -> {
                System.out.println("Has elegido la opción 3.");
                return Orientacion.ESTE;
            }
            case 4 -> {
                System.out.println("Has elegido la opción 4.");
                return Orientacion.SURESTE;
            }
            case 5 -> {
                System.out.println("Has elegido la opción 5.");
                return Orientacion.SUR;
            }
            case 6 -> {
                System.out.println("Has elegido la opción 6.");
                return Orientacion.SUROESTE;
            }
            case 7 -> {
                System.out.println("Has elegido la opción 7.");
                return Orientacion.OESTE;
            }
            case 8 -> {
                System.out.println("Has elegido la opción 8.");
                return Orientacion.NOROESTE;
            }
            default -> {
                System.out.println("Opción no válida.");
                return null;
            }
        }
    }

    public static Coordenada elegirCoordenada() {
        int coordenadaX;
        int coordenadaY;

        try {
            System.out.print("Introduce el valor de la coordenada X: ");
            coordenadaX = Entrada.entero();
            System.out.println("Introduce el valor de la coordenada Y: ");
            coordenadaY = Entrada.entero();
            new Coordenada(coordenadaX, coordenadaY);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            coordenadaX = coordenadaY = 0;
        }
        return new Coordenada(coordenadaX, coordenadaY);
    }

    public static char elegirComando() {
        char elegirComando;

        System.out.println("Menú de Comandos: ");
        System.out.println("(a, A) Avanzar.");
        System.out.println("(d, D) Girar a la Derecha.");
        System.out.println("(i, I) Girar a la Izquierda.");
        System.out.print("Elige un comando: ");
        elegirComando = Entrada.caracter();

        switch (elegirComando) {
            case 'a', 'A' -> System.out.println("Has elegido avanzar.");
            case 'd', 'D' -> System.out.println("Has elegido girar a la derecha.");
            case 'i', 'I' -> System.out.println("Has elegido girar a la izquierda.");
            default -> System.out.println("Comando no reconocido.");
        }
        return elegirComando;
    }

    public static void mostrarRobot(ControladorRobot controladorRobot) {
        Objects.requireNonNull(controladorRobot, "El controlador del Robot es nulo.");
        Robot robot = controladorRobot.getRobot();
        System.out.println(robot);
    }

    public static void despedirse() {
        System.out.println("¡Hasta la próxima!");
    }
}