package Modelo.Personajes;

import Modelo.Unidad;
import java.util.ArrayList;

public class Himeko extends Unidad {

    public Himeko(int hpMax, String nombre, int hp, int defensa, int ataque, int energia) {
        super(hpMax, nombre, hp, defensa, ataque, energia);
        this.habilidades = new ArrayList<>();
        this.habilidades.add("Ataque básico: Afinación de sierra");
        this.habilidades.add("Habilidad básica: Detonación fundida");
        this.habilidades.add("Habilidad definitiva: Llamas celestiales");
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
        if (skillpoint > 1) {
            int ataqueTotal = (int) (this.ataque * 1.5);
            enemigo.recibirDanio(ataqueTotal);
            return skillpoint - 1;
        } else {
            return skillpoint;
        }
    }

    @Override
    public void habilidadDefinitiva(Unidad enemigo) {
        int ataqueTotal = this.ataque * 4;
        enemigo.recibirDanio(ataqueTotal);
        this.setEnergia(0);
    }

}
