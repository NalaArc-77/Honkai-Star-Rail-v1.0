package Controlador;

import Modelo.Enemigo;

import Modelo.Unidad;
import Vista.Combate;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Modelo.ReproducirMusica;

public class ControladorCombate implements ActionListener {
    
    private final Combate combate;
    private final ArrayList<Unidad> equipoJugador;
    private final Enemigo enemigo;
    private int turnoActual = 0;
    private int puntosHabilidad = 5;
    private final int recargaEnergia = 25;
    
    public ControladorCombate(Combate fm, ArrayList<Unidad> equipoJugador, Enemigo enemigo) {
        combate = fm;
        this.equipoJugador = equipoJugador;
        this.enemigo = enemigo;
        combate.cbxAtaques.addActionListener(this);
        combate.btnAtacar.addActionListener(this);
        combate.cbxAtaques.removeAllItems();
        
        
        fm.setResizable(false);
        fm.setLocationRelativeTo(null);
        fm.setVisible(true);
        dibujarEnemigo(enemigo.getNombre());
        actualizarInterfazYTurno();
        reproducirMusica(enemigo.getNombre());
    }
    
    private void reproducirMusica(String boosTheme) {
        switch (boosTheme) {
            case "Sunday" -> {
                ReproducirMusica sunday = new ReproducirMusica();
                sunday.reproducirMusica("src/Vista/Sonidos/Hope.wav");
                combate.setTitle("Hora del combate!!! || Reproduciendo... Hope Is The Thing With Feathers - Robin");
            }
            case "Aquila" -> {
                ReproducirMusica aquila = new ReproducirMusica();
                aquila.reproducirMusica("src/Vista/Sonidos/ProiProi.wav");
                combate.setTitle("Hora del combate!!! || Reproduciendo... Proi Proi - NIDA");
            }
            default -> {
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == combate.btnAtacar) {
            if (equipoJugador.isEmpty()) {
                combate.txtArea.append("¡Todos los personajes han sido derrotados! GAME OVER\n");
                combate.btnAtacar.setEnabled(false);
                return;
            }
            
            Unidad actual = equipoJugador.get(turnoActual);
            String habilidadNombre = (String) combate.cbxAtaques.getSelectedItem();
            int habilidad = combate.cbxAtaques.getSelectedIndex();
            
            switch (habilidad) {
                case 0 -> {
                    combate.txtArea.append(actual.getNombre() + " usó " + habilidadNombre + " sobre " + enemigo.getNombre() +" 🗡️🗡️🗡️"+"\n");
                    actual.ataqueBasico(enemigo);
                    actual.setEnergia(actual.getEnergia() + recargaEnergia);
                    combate.txtArea.append("HP enemigo: " + enemigo.getHp() + "\n");
                    if (puntosHabilidad < 5) {
                        puntosHabilidad++;
                    }
                }
                case 1 -> {
                    if (puntosHabilidad > 1) {
                        combate.txtArea.append(actual.getNombre() + " usó " + habilidadNombre + " sobre " + enemigo.getNombre() +" ⚡⚡⚡"+ "\n");
                        puntosHabilidad = actual.habilidadBasica(enemigo, puntosHabilidad);
                        combate.txtArea.append("HP enemigo: " + enemigo.getHp() + "\n");
                        actual.setEnergia(actual.getEnergia() + recargaEnergia);
                    } else {
                        JOptionPane.showMessageDialog(null, "No tienes suficientes puntos de habilidad!!!");
                        return;
                    }
                }
                case 2 -> {
                    if (actual.getEnergia() >= 200) {
                        combate.txtArea.append(actual.getNombre() + " usó " + habilidadNombre + " sobre " + enemigo.getNombre() + "\n");
                        actual.habilidadDefinitiva(enemigo);
                        combate.txtArea.append("HP enemigo: " + enemigo.getHp() +" 🌠🌠🌠"+ "\n");
                    } else {
                        JOptionPane.showMessageDialog(null, "No tienes suficiente energía");
                        return;
                    }
                }
                default ->
                    throw new AssertionError();
            }
            
            combate.lblPuntosHabilidad.setText("Tus puntos de habilidad: " + puntosHabilidad);
            
            if (enemigo.getHp() <= 0) {
                combate.txtArea.append("¡" + enemigo.getNombre() + " ha sido derrotado!\n");
                combate.btnAtacar.setEnabled(false);
                return;
            }
            
            if (turnoActual == equipoJugador.size() - 1) {
                enemigoAtaca();
            }
            
            turnoActual = (turnoActual + 1) % equipoJugador.size();
            equipoJugador.removeIf(personaje -> personaje.getHp() <= 0);

            if (equipoJugador.isEmpty()) {
                combate.txtArea.append("¡Todos los personajes han sido derrotados! GAME OVER\n");
                combate.btnAtacar.setEnabled(false);
                return;
            }
            
            actualizarInterfazYTurno();
        }
    }
    
    private void actualizarInterfazYTurno() {
        Unidad actual = equipoJugador.get(turnoActual);
        
        combate.lblPersonaje.setText(actual.getNombre());
        combate.lblMostradorDeTurnos.setText("Turno de: " + actual.getNombre());
        combate.lblPuntosHabilidad.setText("Tus puntos de habilidad: " + puntosHabilidad);
        combate.lblPersonajeActual.setText(actual.getNombre());
        combate.lblVidaActual.setText("Vida:" + actual.getHp());
        combate.lblEnergiaActual.setText("Energía:" + actual.getEnergia());
        
        combate.cbxAtaques.removeAllItems();
        for (String habilidad : actual.getHabilidades()) {
            combate.cbxAtaques.addItem(habilidad);
        }
        
        combate.txtArea.append("Turno de " + actual.getNombre() + "\n");
        
        ImageIcon icono = new ImageIcon("src/Vista/imagenes/" + actual.getNombre() + ".png");
        Image imagenEscalada = icono.getImage().getScaledInstance(
                combate.lblPersonaje.getWidth(),
                combate.lblPersonaje.getHeight(),
                Image.SCALE_SMOOTH
        );
        combate.lblPersonaje.setIcon(new ImageIcon(imagenEscalada));
        
    }
    
    private void enemigoAtaca() {
        combate.txtArea.append("\nTurno del enemigo: " + enemigo.getNombre() + "\n");
        
        ArrayList<Unidad> vivos = new ArrayList<>();
        for (Unidad u : equipoJugador) {
            if (u.getHp() > 0) {
                vivos.add(u);
            }
        }
        
        if (vivos.isEmpty()) {
            combate.txtArea.append("¡Todos los personajes han sido derrotados! GAME OVER\n");
            combate.btnAtacar.setEnabled(false);
            return;
        }
        
        int i = (int) (Math.random() * vivos.size());
        Unidad objetivo = vivos.get(i);
        
        enemigo.ataqueBasico(objetivo);

        combate.txtArea.append("--->"+enemigo.getNombre() + " atacó a " + objetivo.getNombre() +"<---"+"\n");
        combate.txtArea.append(objetivo.getNombre() + " tiene ahora " + objetivo.getHp() + " HP 💔💔💔"+"\n");
    }
    
    private void dibujarEnemigo(String nombre) {
        ImageIcon icono = new ImageIcon("src/Vista/imagenes/" + nombre + ".png");
        Image imagenEscalada = icono.getImage().getScaledInstance(
                combate.lblPersonaje.getWidth(),
                combate.lblPersonaje.getHeight(),
                Image.SCALE_SMOOTH
        );
        combate.lblJefe.setIcon(new ImageIcon(imagenEscalada));
    }
}
