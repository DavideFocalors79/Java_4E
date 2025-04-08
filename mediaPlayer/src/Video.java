public class Video {
    private String titolo;
    private boolean riproduzione = false;
    private int durata; //minuti

    public Video(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    public void cambiaRiproduzione(){
        if(this.riproduzione == false){
            this.riproduzione = true;
        }else{
            this.riproduzione = false;
        }
    }

    public Boolean getRiproduzione() {
        return this.riproduzione;
    }

    public String getTitolo() {
        return this.titolo;
    }
}
