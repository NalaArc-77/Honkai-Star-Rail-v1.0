package Modelo.EfectosEstados;

import Modelo.EfectoEstado;
import Modelo.Unidad;

public class Curacion extends EfectoEstado{
    
    public Curacion(String nombre, int duracionTruno) {
        super(nombre, duracionTruno);
    }
    
    @Override
    public void aplicarEfecto(Unidad personaje){
        
    }
}