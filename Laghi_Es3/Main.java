import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n1=0,n2=0,divisione=0;
        boolean j;
        Scanner keyboard = new Scanner(System.in);

        do {
            j = true;

            try {

                n1 = getsInteger(keyboard);
                n2 = getsInteger(keyboard);

                divisione=getsDivison(n2,n1);

            } catch (Exception e) {
                System.out.println("Errore!");
                System.out.println(e.getMessage());
                j = false;
            }
        }while(!j);

        System.out.println("La divisone e': "+divisione);
    }

    private static int getsInteger(Scanner keyboard) throws Exception
    {
        int num= -1;

        System.out.println("inserisci un valore: ");
        num = Integer.parseInt(keyboard.nextLine());
        if(num >=0){
            return num;
        }else{
            throw new Exception("Valore non valido");
        }


    }

    private static int getsDivison(int n2,int n1) throws Exception
    {
        if(n2 !=0){
            return n1/n2;
        }else{
            throw new Exception("Valore non valido");
        }
    }
}