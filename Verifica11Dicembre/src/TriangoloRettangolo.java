public class TriangoloRettangolo {
    private double base;
    private double altezza;

    /*costruttore della classe TriangoloRettangolo, inizializza un oggetto TriangoloRettangolo con la base e l'altezza specificate*/
    public TriangoloRettangolo(double base, double altezza) {
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
        return (base * altezza) / 2;
    }
    /* Il metodo stampa a video gli attributi del Triangolo rettangolo*/
    public String getInformazioni(){
        return String.format("Triangolo rettangolo con base %.1f e altezza %.1f", this.base, this.altezza);
    }

    /* Il metodo confronta due Triangolirettangoli di cui uno è lo stesso che viene richiamato
     e il secondo viene passato nel metodo, il metodo restituisce:
      1 se l'area dell'oggetto attuale è maggiore.
      0 se le aree sono uguali.
     -1 se l'area dell'oggetto attuale è minore.
    */
    public int compareTo(TriangoloRettangolo altro){
        double areaQuesto = this.calcolaArea();
        double areaAltro = altro.calcolaArea();
        return Double.compare(areaQuesto,areaAltro );
    }
}