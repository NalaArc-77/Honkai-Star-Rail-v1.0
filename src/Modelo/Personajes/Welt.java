package Modelo.Personajes;

import Modelo.Unidad;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Welt extends Unidad {

    public Welt(int hpMax, String nombre, int hp, int defensa, int ataque, int energia) {
        super(hpMax, nombre, hp, defensa, ataque, energia);
        this.habilidades = new ArrayList<>();
        this.habilidades.add("Ataque básico: Supresión de la gravedad");
        this.habilidades.add("Habilidad Básica: Filo del vacío");
        this.habilidades.add("Habilidad definitiva: Agujero negro artificial");
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
    public int habilidadBasica(Unidad enemigo, int skillpoints) {
        if (skillpoints > 1) {
            int ataqueTotal = (int) (this.getAtaque() * 3.5);
            enemigo.recibirDanio(ataqueTotal);
            return skillpoints - 1;
        } else {
            return skillpoints;
        }
    }

    @Override
    public void habilidadDefinitiva(Unidad enemigo) {
        int ataqueTotal = this.getAtaque() + this.getAtaque() * this.getHpMax();
        enemigo.recibirDanio(ataqueTotal);
        this.setEnergia(0);
    }
}
