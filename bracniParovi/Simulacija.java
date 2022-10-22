package bracniParovi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileReader;

public class Simulacija extends Frame {
private TextField ponavljanja;
private Button pokreni, ispocetka;
private TextArea ispis;
private TextField frekvencija;
private int metoda;
private int brPonavljanja;
private List lista;

    private class Greska extends Dialog {
        private Button b;
        Greska(Frame owner){
            super(owner,"GRESKA",ModalityType.MODELESS);
            setBounds(800,300,100,80);
            Label l = new Label("Nije upisana vrednost za broj ponavljanja");
            Panel p1 = new Panel();
            p1.add(l);
            Panel p2 = new Panel();
            b = new Button("Zatvori");
            p2.add(b);
            add(l,BorderLayout.CENTER);
            add(b,BorderLayout.SOUTH);
            setResizable(false);
            setVisible(true);
            b.addActionListener((al)->{
                Greska.this.dispose();
            });
        }
    }

public Simulacija(){
    super("VIS6: Bracni parovi - Generisanje pseudoslucajnih brojeva koriscenjem razlicitih generatora");
    Panel severni = new Panel();
    metoda = 0;
    Label l1 = new Label("Broj ponavljanja:");
    Label lx = new Label("Metoda generisanja:");
    lista = new List(3,false);
    lista.add("Math.Random");
    lista.add("util.Random");
    lista.add("util.concurrent.ThreadLocalRandom");
    ponavljanja = new TextField("",5);
    pokreni = new Button("Pokreni simulaciju!");
    severni.add(l1);
    severni.add(ponavljanja);
    severni.add(lx);
    severni.add(lista);
    severni.add(pokreni);

    Panel centralni = new Panel();
    ispis = new TextArea();
    ispis.setEditable(false);
    Label l2 = new Label("Inicijalno parovi: 0-5 1-6 2-7 3-8 4-9");
    centralni.add(ispis);
    centralni.add(l2);

    Panel juzni = new Panel();
    Label l3 = new Label("Frekvencija:");
    frekvencija = new TextField("",30);
    frekvencija.setEnabled(false);
    ispocetka = new Button("Ispocetka?");
    juzni.add(l3);
    juzni.add(frekvencija);
    juzni.add(ispocetka);

    add(severni,BorderLayout.NORTH);
    add(centralni,BorderLayout.CENTER);
    add(juzni,BorderLayout.SOUTH);

    pokreni.addActionListener((ae)->{
        if(ponavljanja.getText().isBlank()){
            Greska g = new Greska(this);
        }
        else {
            pokreni.setEnabled(false);
            brPonavljanja = Integer.parseInt(ponavljanja.getText());
            ponavljanja.setEnabled(false);
            Generator generator = new Generator(brPonavljanja,metoda);
            generator.startuj();
            ispis.setText(generator.vratiTekst());
            frekvencija.setText(generator.vratiFrekvenciju());
        }
    });
    ispocetka.addActionListener((ae2)->{
        ponavljanja.setText("");
        pokreni.setEnabled(true);
        ispis.setText("");
        frekvencija.setText("");
        ponavljanja.setEnabled(true);
    });
    lista.addItemListener((l)->{
        metoda = lista.getSelectedIndex();
    });

    setBounds(700, 200, 500, 400);
    setResizable(false);
    setVisible(true);
    pack();
    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            dispose();
        }
    });
}

public static void main(String[] args){
    new Simulacija();
}

}

