public class Rettangolo {
    private double base;
    private double altezza;

    /*costruttore della classe Rettangolo, inizializza un oggetto Rettangolo con la base e l'altezza specificate*/
    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }
    /*il metodo prende la base e l'altezza dell'oggeto stesso e ne calcola l'area*/
    public double calcolaArea() {
        return base * altezza;
    }

    /*chi usa la classe non ha bisogno di sapere come viene calcolato il perimetro
    ma può semplicemente chiamare il metodo calcolaPerimetro() per fare vari scopi di comparazione o altro
    il metodo prende la base e l'altezza dell'oggeto stesso e ne calcola il perimetro
     */
    public double calcolaPerimetro() {
        return 2 * (this.base + this.altezza);
    }

    /* Il metodo stampa a video gli attributi del rettangolo*/
    public String getInformazioni(){
        return String.format("Rettangolo con base %.1f e altezza %.1f", this.base, this.altezza);
    }

    /* Il metodo confronta due rettangoli di cui uno è lo stesso che viene richiamato
     e il secondo viene passato nel metodo, il metodo restituisce:
      1 se l'area dell'oggetto attuale è maggiore.
      0 se le aree sono uguali.
     -1 se l'area dell'oggetto attuale è minore.
    */
    public int compareTo(Rettangolo altro){
        double areaQuesto = this.calcolaArea();
        double areaAltro = altro.calcolaArea();
        return Double.compare(areaQuesto,areaAltro );
    }


}