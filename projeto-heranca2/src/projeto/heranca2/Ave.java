package projeto.heranca2;

public class Ave {
    protected Double peso;

    public Ave(Double peso) {
        this.peso = peso;
    }    
    
    public void voar(){
        System.out.println("Voar, voar, subir, subir...");
    }

    @Override
    public String toString() {
        return String.format("Ave\nPeso: %.2fKG\n", this.peso);
    }
    
}
