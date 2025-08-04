package Modelo.EfectosEstados;

import Modelo.EfectoEstado;
import Modelo.Enemigo;


public class Quemadura extends EfectoEstado{
    
    public Quemadura(String nombre, int duracionTruno) {
        super(nombre, duracionTruno);
    }
    
   
    public void aplicarEfecto(Enemigo objetivo) {
        System.out.println(objetivo.getNombre() + " está congelado y no puede actuar. (" + duracionTruno + " turnos restantes)");
    }
}