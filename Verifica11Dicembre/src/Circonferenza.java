public class Circonferenza {
    private double raggio;

    /*costruttore della classe TriangoloRettangolo, inizializza un oggetto Circonferenza con il Raggio specificato*/
    public Circonferenza(double raggio) {
        this.raggio = raggio;
    }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }
    /*il metodo prende il raggio dell'oggetto stesso e ne calcola l'area*/
    public double calcolaArea() {
        return Math.PI * raggio * raggio;
    }

    /* Il metodo stampa a video gli attributi della Circonferenza*/
    public String getInformazioni(){
        return String.format("Raggio della circonferenza: %.1f", this.raggio);
    }


    /* Il metodo confronta due Circonferenze di cui una è lo stessa che viene richiamata
    e la seconda viene passata nel metodo, il metodo restituisce:
     1 se l'area dell'oggetto attuale è maggiore.
     0 se le aree sono uguali.
    -1 se l'area dell'oggetto attuale è minore.
   */
    public int compareTo(Circonferenza altro){
        double areaQuesto = this.calcolaArea();
        double areaAltro = altro.calcolaArea();
        return Double.compare(areaQuesto,areaAltro );
    }
}