package projeto.heranca2;

public class Aguia extends Ave{

    public Aguia(Double peso) {
        super(peso);
    }

    @Override
    public void voar() {
        System.out.println("Voando alto...");
    }

    @Override
    public String toString() {
        return String.format("Águia\nPeso: %.2fKG\n", this.peso);
    }
    
    
    
    
}
