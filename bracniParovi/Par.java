package bracniParovi;

public class Par {
    private int osoba1; //muskarac
    private int osoba2; //zena
    //mora da se razlikuje jer ne moze plesni par da bude musko musko ili zensko zensko
    private boolean bracni;
    public Par(int o1,int o2){
        osoba1 = o1;
        osoba2 = o2;
    }
    public void setBracni(boolean vr){
        bracni = vr;
    }

    boolean bracni(){
        if(Math.abs(osoba2-osoba1) == 5)
            return true;
        else
            return false;
    }

    public String toString(){
        String s = Integer.toString(osoba1) + "-" + Integer.toString(osoba2);
        return s;
    }
}
