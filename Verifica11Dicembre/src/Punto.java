public class Punto {

    private double x;
    private double y;

    /*costruttore della classe Punto, inizializza un oggetto Punto con le coordinate specificate*/
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    /*il metodo prende il due punti quando viene
      chiamato e calcola la lunghezza del segmento tra
      i due con il teorema di pitagora
    */
    public double calcolaLunghezza(Punto punto, Punto punto2){
        return Math.sqrt(Math.pow(punto.getX()-punto2.getX(), 2)+Math.pow(punto.getY()-punto2.getY(),2));
    }


}
