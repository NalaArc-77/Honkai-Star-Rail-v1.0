package Controlador;

import Modelo.ReproducirMusica;
import Vista.EligirPersonajes;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal implements ActionListener {

    Principal principal;
    EligirPersonajes eleccion;
    ControladorElegirPersonajes controlEleccion;
    ReproducirMusica reproducirMenu;
    
    public ControladorPrincipal(Principal fm) {

        principal = fm;
        principal.btnComenzar.addActionListener(this);
        fm.setTitle("Bienvenido Trazacaminos");
        fm.setLocationRelativeTo(null);
        fm.setResizable(false);
        fm.setVisible(true);
        
        reproducirMenu = new ReproducirMusica();
        reproducirMenu.reproducirMusica("src/Vista/Sonidos/StarRailOST.wav");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.btnComenzar) {
            principal.setVisible(false);
            eleccion = new EligirPersonajes();
            controlEleccion = new ControladorElegirPersonajes(eleccion, reproducirMenu);
        }
    }

}
