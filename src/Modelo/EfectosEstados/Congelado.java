package Modelo.EfectosEstados;

import Modelo.EfectoEstado;
import Modelo.Enemigo;

public class Congelado extends EfectoEstado {

    public Congelado(String nombre, int duracionTruno) {
        super(nombre, duracionTruno);
    }

    public void aplicarEfecto(Enemigo enemigo) {
        perderTurno();
    }

    public boolean perderTurno() {
        return true;
    }
}
