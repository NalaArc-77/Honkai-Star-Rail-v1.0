package Modelo;

public class EfectoEstado {

    protected String nombre;
    protected int duracionTruno;

    public EfectoEstado(String nombre, int duracionTruno) {
        this.nombre = nombre;
        this.duracionTruno = duracionTruno;
    }

    public void aplicarEfecto(Unidad personaje) {
        System.out.println(personaje.nombre + " está afectado por " + nombre);
    }

    public void disminuirEfecto() {
        if (duracionTruno > 0) {
            duracionTruno--;
        }
    }

    public boolean estaActivo() {
        return duracionTruno > 0;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracionTruno;
    }
    
    //Proximamente waa
}