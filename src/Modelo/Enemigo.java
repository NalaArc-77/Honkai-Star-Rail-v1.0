package Modelo;

import java.util.ArrayList;

public class Enemigo extends Unidad{

    public Enemigo(int hpMax, String nombre, int hp, int defensa, int ataque, int energia) {
        super(hpMax, nombre, hp, defensa, ataque, energia);
        this.habilidades = new ArrayList<>();
        this.habilidades.add("Admonición resplandeciente");
        this.habilidades.add("Concesión del papel y los ritos");
        this.habilidades.add("Ayúdame Xipe...");
    }

    

    @Override
    public void ataqueBasico(Unidad personaje) {
        int ataqueTotal = (int) (this.getAtaque() - personaje.defensa * 0.3);
        personaje.recibirDanio(ataqueTotal);
    }

    @Override
    public void recibirDanio(int danio) {
        int danioRecibido = this.getHp() - danio;
        this.setHp(danioRecibido);
    }

    @Override
    public void recibirCuracion(int curacion) {
        int curacionRecibida = this.getHp() + curacion;
        this.setHp(curacionRecibida);
    }

    @Override
    public boolean derrotado(int hp) {
        return this.getHp() < 0;
    }

    @Override
    public int habilidadBasica(Unidad enemigo, int skillpoint) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void habilidadDefinitiva(Unidad enemigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
