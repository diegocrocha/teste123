package projeto.heranca2;

import java.util.ArrayList;

public class TesteAve {
    public static void main(String[] args) {
        Ave ave = new Ave(7.0);
        ave.voar();
        System.out.println(ave);
        
        Galinha g1 = new Galinha(30.0);
        g1.voar();
        System.out.println(g1);
        
        Aguia a1 = new Aguia(75.0);
        a1.voar();
        System.out.println(a1);        
        
    }
 
}
