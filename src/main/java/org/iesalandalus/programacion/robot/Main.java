package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.robot.vista.Consola;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) {
        int aux;
        do {
            Consola.mostrarMenuPrincipal();
            aux = Consola.elegirOpccion();
            ejecutarOpcion(aux);
        } while (aux != 6);
    }

    private static ControladorRobot controladorRobot;

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> ejecutarComando();
            case 6 -> Consola.despedirse();
        }
    }

    private static void controlarRobotDefecto() {
        Robot robotDefecto = new Robot();
        controladorRobot = new ControladorRobot(robotDefecto);
        Consola.mostrarRobot(controladorRobot);
    }

    private static void controlarRobotZona() {
        Zona zonaDefecto = Consola.elegirZona();
        Robot robotZona = new Robot(zonaDefecto);
        controladorRobot = new ControladorRobot(robotZona);
        Consola.mostrarRobot(controladorRobot);

    }

    private static void controlarRobotZonaOrientacion() {
        Zona zonaOrientacion = Consola.elegirZona();
        Consola.mostrarMenuOrientacion();
        Orientacion orientacion = Consola.elegirOrientacion();
        Robot robotZonaOrientacion = new Robot(zonaOrientacion, orientacion);
        controladorRobot = new ControladorRobot(robotZonaOrientacion);
        Consola.mostrarRobot(controladorRobot);

    }

    private static void controlarRobotZonaOrientacionCoordenada() {
        Zona zonaOrientacionCoordenada = Consola.elegirZona();
        Consola.mostrarMenuOrientacion();
        Orientacion orientacion = Consola.elegirOrientacion();
        Coordenada coordenada = Consola.elegirCoordenada();
        Robot robotZonaOrientacionCoordenada = new Robot(zonaOrientacionCoordenada, orientacion, coordenada);
        controladorRobot = new ControladorRobot(robotZonaOrientacionCoordenada);
        Consola.mostrarRobot(controladorRobot);
    }

    private static void ejecutarComando() {
        char comando = Consola.elegirComando();
        try {
            controladorRobot.ejecutar(comando);
            Consola.mostrarRobot(controladorRobot);
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
