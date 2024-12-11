public class Poligono {

    private int lati;

    private double LunghezzaLato;

    /*costruttore della classe Poligono, inizializza un oggetto Poligono con i lati e la lunghezza di essi specificate*/
    public Poligono(int lati, double LunghezzaLato){
        this.lati = lati;
        this.LunghezzaLato = LunghezzaLato;
    }

    public int getLati() {
        return lati;
    }

    public void setLati(int lati) {
        this.lati = lati;
    }

    public double getLunghezzaLato() {
        return LunghezzaLato;
    }

    public void setLunghezzaLato(double lunghezzaLato) {
        LunghezzaLato = lunghezzaLato;
    }

    /*il metodo prende i lati e la lunghezza di essi dell'oggeto stesso e ne calcola il perimetro*/
    public double calcolaPerimetro(){
        return this.lati * this.LunghezzaLato;
    }

    /* Il metodo stampa a video gli attributi del Poligono*/
    @Override
    public String toString(){
        return String.format("Poligono con %d lati di lunghezza %.1f, perimetro: %.1f", this.lati, this.LunghezzaLato, calcolaPerimetro());
    }
}
