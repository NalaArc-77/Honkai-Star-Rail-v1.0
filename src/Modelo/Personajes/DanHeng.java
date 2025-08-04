package Modelo.Personajes;

import Modelo.Unidad;
import java.util.ArrayList;

public class DanHeng extends Unidad {

    public DanHeng(int hpMax, String nombre, int hp, int defensa, int ataque, int energia) {
        super(hpMax, nombre, hp, defensa, ataque, energia);
        this.habilidades = new ArrayList<>();
        this.habilidades.add("Ataque básico: Viento del norte");
        this.habilidades.add("Habilidad básica: Libre de ataduras");
        this.habilidades.add("Habilidad definitiva: Purificación del mundo");
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
    public int habilidadBasica(Unidad enemigo, int skillPoint) {
        if (skillPoint > 3) {
            int danioTotal = (int) (this.ataque * 0.3);
            enemigo.recibirDanio(danioTotal);
            return skillPoint - 3;
        } else {
            return skillPoint;
        }
    }

    @Override
    public void habilidadDefinitiva(Unidad enemigo) {
        int ataqueTotal = ataque * 3;
        enemigo.recibirDanio(ataqueTotal);
        this.setEnergia(0);
    }

}
