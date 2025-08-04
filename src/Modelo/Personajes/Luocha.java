package Modelo.Personajes;

import Modelo.Unidad;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Luocha extends Unidad{

    public Luocha(int hpMax, String nombre, int hp, int defensa, int ataque, int energia) {
        super(hpMax, nombre, hp, defensa, ataque, energia);
        this.habilidades = new ArrayList<>();
        this.habilidades.add("Ataque básico: Espinas del abismo");
        this.habilidades.add("Habilidad básica: Oración de la flor abisal");
        this.habilidades.add("Habilidad definitiva: Deseo de muerte");
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
    public int habilidadBasica(Unidad personaje, int skillpoint){
        if (skillpoint > 1) {
            int curacionTotal = (int) (this.hpMax * 0.3);
            personaje.recibirCuracion(curacionTotal);
            return skillpoint - 1;
        }else{
            return skillpoint;
        }
    }
    
    @Override
    public void habilidadDefinitiva(Unidad enemigo) {
            int reducDef = this.getHpMax() * 10;
            enemigo.setDefensa(enemigo.getDefensa()-reducDef);
            this.setEnergia(0);
    }
    
}
