package Principal;

import Controlador.ControladorPrincipal;
import Vista.Principal;

public class Main {
    
    public static Principal principal;
    public static ControladorPrincipal control;
    
    public static void main(String[] args){
        principal = new Principal();
        control = new ControladorPrincipal(principal);
        
        
    }
}
