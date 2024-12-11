public class Quadrato {
    private double lato;

    /*costruttore della classe Quadrato, inizializza un oggetto Quadrato con il lato specificato*/
    public Quadrato(double lato) {
        this.lato = lato;
    }

    public double getLato() {
        return lato;
    }

    public void setLato(double lato) {
        this.lato = lato;
    }
    /*il metodo prende il lato dell'oggeto stesso e ne calcola l'area*/
    public double calcolaArea() {
        return lato * lato;
    }
    /* Il metodo stampa a video gli attributi del Quadrato*/
    public String getInformazioni(){
        return String.format("Latp del Quadrato: %.1f", this.lato);
    }

    /* Il metodo confronta due Quadrati di cui uno è lo stesso che viene richiamato
     e il secondo viene passato nel metodo, il metodo restituisce:
      1 se l'area dell'oggetto attuale è maggiore.
      0 se le aree sono uguali.
     -1 se l'area dell'oggetto attuale è minore.
    */
    public int compareTo(Quadrato altro){
        double areaQuesto = this.calcolaArea();
        double areaAltro = altro.calcolaArea();
        return Double.compare(areaQuesto,areaAltro );
    }
}