package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Robot {
    private Orientacion orientacion;
    private Coordenada coordenada;
    private Zona zona;

    public Robot() {
        zona = new Zona();
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona) {
        this();
        setZona(zona);
        setCoordenada(zona.getCentro());
    }

    public Robot(Zona zona, Orientacion orientacion) {
        this(zona);
        setOrientacion(orientacion);
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        this(zona, orientacion);
        setCoordenada(coordenada);
    }

    public Robot(Robot robot) {
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        zona = robot.zona;
        coordenada = robot.coordenada;
        orientacion = robot.orientacion;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        this.orientacion = Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private void setCoordenada(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        if (!zona.pertenece(coordenada)) {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.coordenada = coordenada;
    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        Objects.requireNonNull(zona, "La zona no puede ser nula.");
        this.zona = zona;
    }

    public void avanzar() throws OperationNotSupportedException {
        int nuevaCoordenadaX = getCoordenada().x();
        int nuevaCoordenadaY = getCoordenada().y();

        switch (orientacion) {
            case NORTE:
                nuevaCoordenadaY++;
                break;
            case NORESTE:
                nuevaCoordenadaY++;
                nuevaCoordenadaX++;
                break;
            case ESTE:
                nuevaCoordenadaX++;
                break;
            case SURESTE:
                nuevaCoordenadaY--;
                nuevaCoordenadaX++;
                break;
            case SUR:
                nuevaCoordenadaY--;
                break;
            case SUROESTE:
                nuevaCoordenadaY--;
                nuevaCoordenadaX--;
                break;
            case OESTE:
                nuevaCoordenadaX--;
                break;
            case NOROESTE:
                nuevaCoordenadaX--;
                nuevaCoordenadaY++;
                break;
            default:
                throw new IllegalArgumentException("Dirección no válida.");
        }
        if (nuevaCoordenadaX < 0 || nuevaCoordenadaX >= zona.ancho() || nuevaCoordenadaY < 0 || nuevaCoordenadaY >= zona.alto()) {
            throw new OperationNotSupportedException("No se puede avanzar, ya que se sale de la zona.");
        } else {
            coordenada = new Coordenada(nuevaCoordenadaX, nuevaCoordenadaY);
        }
    }

    public void girarALaDerecha() {
        switch (orientacion) {
            case NORTE:
                orientacion = Orientacion.NORESTE;
                break;
            case NORESTE:
                orientacion = Orientacion.ESTE;
                break;
            case ESTE:
                orientacion = Orientacion.SURESTE;
                break;
            case SURESTE:
                orientacion = Orientacion.SUR;
                break;
            case SUR:
                orientacion = Orientacion.SUROESTE;
                break;
            case SUROESTE:
                orientacion = Orientacion.OESTE;
                break;
            case OESTE:
                orientacion = Orientacion.NOROESTE;
                break;
            case NOROESTE:
                orientacion = Orientacion.NORTE;
                break;
            default:
                throw new IllegalArgumentException("Dirección no válida.");

        }
    }

    public void girarALaIzquierda() {
        switch (orientacion) {
            case NORTE:
                orientacion = Orientacion.NOROESTE;
                break;
            case NORESTE:
                orientacion = Orientacion.NORTE;
                break;
            case ESTE:
                orientacion = Orientacion.NORESTE;
                break;
            case SURESTE:
                orientacion = Orientacion.ESTE;
                break;
            case SUR:
                orientacion = Orientacion.SURESTE;
                break;
            case SUROESTE:
                orientacion = Orientacion.SUR;
                break;
            case OESTE:
                orientacion = Orientacion.SUROESTE;
                break;
            case NOROESTE:
                orientacion = Orientacion.OESTE;
                break;
            default:
                throw new IllegalArgumentException("Dirección no válida.");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return orientacion == robot.orientacion && Objects.equals(coordenada, robot.coordenada) && Objects.equals(zona, robot.zona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientacion, coordenada, zona);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "orientacion=" + orientacion +
                ", coordenada=" + coordenada +
                ", zona=" + zona +
                '}';
    }
}
