public class Canzone {
    private String titolo;
    private String artista;
    private boolean riproduzione = false;

    public Canzone(String titolo, String artista) {
        this.titolo = titolo;
        this.artista = artista;
    }

    public Boolean getRiproduzione() {
        return this.riproduzione;
    }

    public void cambiaRiproduzione(){
        if(this.riproduzione == false){
            this.riproduzione = true;
        }else{
            this.riproduzione = false;
        }
    }

    public String getTitolo() {
        return this.titolo;
    }
}
