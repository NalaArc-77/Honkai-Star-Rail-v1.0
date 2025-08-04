package Controlador;

import Modelo.Enemigo;
import Modelo.Personajes.*;
import Modelo.ReproducirMusica;
import Modelo.Unidad;
import Vista.Combate;
import Vista.EligirPersonajes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorElegirPersonajes implements ActionListener {

    EligirPersonajes personajes;
    Combate combate;
    ControladorCombate controlCombate;
    ReproducirMusica reproductor;

    public ControladorElegirPersonajes(EligirPersonajes fm, ReproducirMusica musica) {
        personajes = fm;
        reproductor = musica;
        
        personajes.btnComenzarPelia.addActionListener(this);
        personajes.cbxEnemigos.addActionListener(this);
        personajes.cbxPersonajes.addActionListener(this);
        personajes.cbxPersonajes1.addActionListener(this);
        personajes.cbxPersonajes2.addActionListener(this);

        fm.setTitle("Elección de Personajes");
        fm.setResizable(false);
        fm.setLocationRelativeTo(null);
        fm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == personajes.btnComenzarPelia) {
            String nombre1 = personajes.cbxPersonajes.getSelectedItem().toString();
            String nombre2 = personajes.cbxPersonajes1.getSelectedItem().toString();
            String nombre3 = personajes.cbxPersonajes2.getSelectedItem().toString();
            String enemigoNombre = personajes.cbxEnemigos.getSelectedItem().toString();

            if(nombre1.equals("--Selecciona--")||nombre2.equals("--Selecciona--")||nombre3.equals("--Selecciona--")||enemigoNombre.equals("--Seleciona--")){
                JOptionPane.showMessageDialog(null, "Selecciona personajes!!!");
                return;
            }
            
            if (nombre1.equals(nombre2) || nombre1.equals(nombre3) || nombre2.equals(nombre3)) {
                JOptionPane.showMessageDialog(null, "No repitas personajes.");
                return;
            }
            
            Unidad p1 = crearPersonaje(nombre1);
            Unidad p2 = crearPersonaje(nombre2);
            Unidad p3 = crearPersonaje(nombre3);
            Enemigo enemigo = crearEnemigo(enemigoNombre);

            ArrayList<Unidad> equipoJugador = new ArrayList<>();
            equipoJugador.add(p1);
            equipoJugador.add(p2);
            equipoJugador.add(p3);

            System.out.println("¡Batalla comenzada!");
            System.out.println("Aliados: " + nombre1 + ", " + nombre2 + ", " + nombre3);
            System.out.println("Enemigo: " + enemigoNombre);

            combate = new Combate();
            controlCombate = new ControladorCombate(combate, equipoJugador, enemigo);
            personajes.setVisible(false);
            reproductor.detenerMusica();
        }

    }

    public Unidad crearPersonaje(String nombre) {
        return switch (nombre) {
            case "Dan Heng" ->
                new DanHeng(5000, "Dan Heng", 5000, 1500, 2000, 200);
            case "Luocha" ->
                new Luocha(6000, "Luocha", 6000, 3000, 1000, 200);
            case "7 de Marzo" ->
                new SieteDeMarzo(8000, "7 de Marzo", 8000, 3000, 1200, 200);
            case "Himeko" ->
                new Himeko(4000,"Himeko", 4000, 2000, 1500, 200);
            case "PomPom" ->
                new PomPom(10000, "PomPom", 10000, 5000, 2500, 500);
            case "Trazacaminos" -> 
                new Trazacaminos(5000, "Trazacaminos", 5000, 2500, 1900, 200);
            case "Welt" ->
                new Welt(5500, "Welt", 5500, 1200, 2000, 200);
            default ->
                null;
        };
    }

    public Enemigo crearEnemigo(String nombre) {
        return switch (nombre) {
            case "Sunday" ->
                new Enemigo(500000, "Sunday", 500000, 2000, 1900, 1000);
            case "Aquila" ->
                new Enemigo(600000, "Aquila", 600000, 3000, 2000, 1500);
            default ->
                null;
        };
    }
}
