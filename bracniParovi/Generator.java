package bracniParovi;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator{
    public static int MATH_RANDOM = 0;
    public static int NEW_RANDOM = 1;
    public static int THREADLOCAL = 2;

    private class Nit extends Thread{
        private int ID;
        Nit(int i){
            ID = i;
        }
        public void run(){
            Par parovi[] = new Par[5];
            int[] zauzet = new int[10];
            for(int i=0;i<10;i++)
                zauzet[i] = 0;

            for(int i=0;i<5;i++){
                int o1,o2;
                while(true){
                    o1 = generisi(vrsta);
                    if(o1 > 4)
                        o1 = o1-5;
                    if(!zauzetaOsoba(o1,zauzet)){
                        zauzet[o1] = 1;
                        break;
                    }
                }
                while(true){
                    o2 = generisi(vrsta);
                    if(o2 < 5)
                        o2 = o2+5;
                    if(!zauzetaOsoba(o2,zauzet)){
                        zauzet[o2] = 1;
                        break;
                    }
                }
                parovi[i] = new Par(o1,o2);
            }

            dodaj(parovi, ID); //dodaj u sb tekst

            int ind = 0;
            for(int i=0;i<5;i++) {
                if (parovi[i].bracni()) {
                    frekvencija[ID] = 1;
                    ind = 1;
                    break;
                }
            }
            System.out.println("KRAJ NITI" + Integer.toString(ID));
        }
    }

    private int brojPonavljanja;
    private Nit[] niti;
    private StringBuilder sb;
    private int vrsta;
    private int[] frekvencija;
    private int generisi(int v){
        int broj;
        if(v == 0){ //Math.random
            broj = (int) (Math.random() * 10);
            return broj;
        }
        else if(v == 1){ //Random()
            broj = new Random().nextInt(10);
            return broj;
        }
        else{ //ThreadLocalRandom
            broj = ThreadLocalRandom.current().nextInt(0,10);
            return broj;
        }
    }

    public String vratiTekst(){ //za textArea
        try{
            for(int i=0;i<brojPonavljanja;i++)
                niti[i].join();
        }
        catch (InterruptedException e){}

        StringBuilder s = new StringBuilder("Ispunjenost zahteva: ");
        for(int i=0;i<brojPonavljanja;i++){
            s.append(frekvencija[i] + " ");
        }
        sb.append(s.toString());
        return sb.toString();
    }

    public String vratiFrekvenciju(){ //za textField frekvencija

        try{
            for(int i=0;i<brojPonavljanja;i++)
                niti[i].join();
        }
        catch (InterruptedException e){}

        double sum = 0;
        for(int i=0;i<brojPonavljanja;i++){
            sum+=(double)frekvencija[i];
        }
        double rez = (double) sum/brojPonavljanja;

        return Double.toString(rez);
    }

    private boolean zauzetaOsoba(int broj,int[] niz){
        if(niz[broj] == 1)
            return true;
        else
            return false;
    }

    public Generator(int frek,int vrsta){
        this.vrsta = vrsta;
        brojPonavljanja = frek;
        frekvencija = new int[brojPonavljanja];
        for(int i=0;i<brojPonavljanja;i++)
            frekvencija[i] = 0;
        sb = new StringBuilder();
        niti = new Nit[frek];
        for(int i=0;i<frek;i++)
            niti[i] = new Nit(i);
    }

    public void startuj(){
        for(int i=0;i<brojPonavljanja;i++)
            niti[i].start();
    }

    public void ugasi(){
        for(int i=0;i<brojPonavljanja;i++)
            niti[i].interrupt();
    }

    private synchronized void dodaj(Par[] parovi, int id){
        sb.append("Generisani niz " + id + ":     ");
        for(int i=0;i<5;i++){
            sb.append(parovi[i].toString());
            sb.append(" ");
        }
        sb.append("\n");
    }
}
