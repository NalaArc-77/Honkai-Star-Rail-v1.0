package Modelo.Personajes;

import Modelo.Unidad;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PomPom extends Unidad {

    public PomPom(int hpMax, String nombre, int hp, int defensa, int ataque, int energia) {
        super(hpMax, nombre, hp, defensa, ataque, energia);
        this.habilidades = new ArrayList<>();
        this.habilidades.add("Ataque básico: Golpe Peludo");
        this.habilidades.add("Habilidad Básica: Tripulación unida");
        this.habilidades.add("Habilidad definitiva: Eco distante del Horizonte");
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
    public int habilidadBasica(Unidad enemigo, int skillpoint) {
        if (skillpoint > 3) {
            int ataqueTotal = (int) (this.getAtaque() * 3.5);
            enemigo.recibirDanio(ataqueTotal);
            return skillpoint - 3;
        } else {
            return skillpoint;
        }
    }

    @Override
    public void habilidadDefinitiva(Unidad enemigo) {
        int ataqueTotal = this.getAtaque() * 10;
        enemigo.recibirDanio(ataqueTotal);
        this.setEnergia(0);

    }
}
