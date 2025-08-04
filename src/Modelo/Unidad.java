package Modelo;

import java.util.ArrayList;

public abstract class Unidad {

    protected int hpMax;
    protected String nombre;
    protected int hp;
    protected int defensa;
    protected int ataque;
    protected int energia;
    protected ArrayList<String> habilidades;

    public Unidad(int hpMax, String nombre, int hp, int defensa, int ataque, int energia) {
        this.hpMax = hpMax;
        this.nombre = nombre;
        this.hp = hp;
        this.defensa = defensa;
        this.ataque = ataque;
        this.energia = energia;
        this.habilidades = new ArrayList<>();
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    public abstract void ataqueBasico(Unidad personaje);
    public abstract void recibirDanio(int danio);
    public abstract void recibirCuracion(int curacion);
    public abstract boolean derrotado(int hp);
    public abstract int habilidadBasica(Unidad enemigo, int skillpoint); 
    public abstract void habilidadDefinitiva(Unidad enemigo);
}