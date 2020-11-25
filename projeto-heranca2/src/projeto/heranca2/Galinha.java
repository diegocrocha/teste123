package projeto.heranca2;

public class Galinha extends Ave{
    
    public Galinha(Double peso) {
        super(peso);
    }

    @Override
    public void voar() {
        System.out.println("Tenta mas não consegue"); 
    }

    @Override
    public String toString() {
        return "Galinha\n" + "Peso: " + this.peso + "KG\n";
    }   
    
    
}
