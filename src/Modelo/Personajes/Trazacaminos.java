package Modelo.Personajes;

import Modelo.Unidad;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Trazacaminos extends Unidad {

    public Trazacaminos(int hpMax, String nombre, int hp, int defensa, int ataque, int energia) {
        super(hpMax, nombre, hp, defensa, ataque, energia);
        this.habilidades = new ArrayList<>();
        this.habilidades.add("Ataque básico: Golpe simple");
        this.habilidades.add("Habilidad Básica: Bate Galáctico");
        this.habilidades.add("Habilidad definitiva: Shibal");
    }

    @Override
    public void ataqueBasico(Unidad personaje) {
        int ataqueTotal = (int) (this.getAtaque());
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
    public int habilidadBasica(Unidad enemigo, int skillponit) {
        if (skillponit > 2) {
            int ataqueTotal = this.getAtaque() + this.getAtaque() * 2;
            enemigo.recibirDanio(ataqueTotal);
            return skillponit - 2;
        } else {
            return skillponit;
        }
    }

    @Override
    public void habilidadDefinitiva(Unidad enemigo) {

        int ataqueTotal = this.getAtaque() + this.getAtaque() * 5;
        enemigo.recibirDanio(ataqueTotal);
        this.setEnergia(0);

    }
}
