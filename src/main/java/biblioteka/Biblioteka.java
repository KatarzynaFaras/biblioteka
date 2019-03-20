package biblioteka;

import java.util.ArrayList;
import java.util.List;

public class Biblioteka {

    private List<Pozycja> katalog;
    private List<Czytelnik> czytelnicy;


    public Biblioteka() {
        this.katalog = new ArrayList<>();
        this.czytelnicy = new ArrayList<>();
    }

    public List<Pozycja> getKatalog() {
        return katalog;
    }

    public List<Czytelnik> getCzytelnicy() {
        return czytelnicy;
    }

    public void dodajPozycja(Pozycja p) {
        katalog.add(p);
    }


    public void usunPozycje(Pozycja p) {
        if (p.getStatus() == Status.DOSTEPNA) {
            katalog.remove(p);
        }
    }


    public void zwrocPozycja(Pozycja p) {
        if (p.getStatus() == Status.DOSTEPNA) {
            System.out.println("Pozycja nie jest wypożyczona." + "\n");
        } else {
            p.setStatus(Status.DOSTEPNA);
            p.setAktualnyCzytelnik(null);
        }
    }


    public void wypozyczPozycje(Pozycja p, Czytelnik cz) {
        if (p.getStatus() == Status.DOSTEPNA) {
            p.setStatus(Status.WYPOZYCZONA);
            p.setAktualnyCzytelnik(cz);
        } else {
            System.out.println("Pozycja jest aktulnie wypożyczona przez kogoś innego." + "\n");
        }
    }



    public void dodajCzytelnik(Czytelnik cz) {
        czytelnicy.add(cz);
    }

    public void stanKatalogu() {
        System.out.println("Aktualne pozycje: ");
        for (int i = 0; i < katalog.size(); i++) {
            System.out.print((i + 1) + ". " + katalog.get(i));
            if (!(katalog.get(i).getAktualnyCzytelnik() == null)) {
                System.out.print(" przez: " + katalog.get(i).getAktualnyCzytelnik());
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Czytelnik czytelnik1 = new Czytelnik("Marcin", "Faraś");
        Czytelnik czytelnik2 = new Czytelnik("Tomasz", "Noga");
        Czytelnik czytelnik3 = new Czytelnik("Mariusz", "Oko");

        Biblioteka biblioteka = new Biblioteka();
        biblioteka.dodajCzytelnik(czytelnik1);
        biblioteka.dodajCzytelnik(czytelnik2);
        biblioteka.dodajCzytelnik(czytelnik3);

        Pozycja ksiazka1 = new Pozycja(TypPozycji.KSIAZKA, "Hobbit", "Tolkien");
        Pozycja ksiazka2 = new Pozycja(TypPozycji.KSIAZKA, "Grom", "Petelicki");
        Pozycja czasopismo1 = new Pozycja(TypPozycji.CZASOPISMO, "Travel");
        Pozycja czasopismo2 = new Pozycja(TypPozycji.CZASOPISMO, "National Geographic");

        biblioteka.dodajPozycja(ksiazka1);
        biblioteka.dodajPozycja(ksiazka2);
        biblioteka.dodajPozycja(czasopismo1);
        biblioteka.dodajPozycja(czasopismo2);

        biblioteka.stanKatalogu();
        biblioteka.wypozyczPozycje(ksiazka1, czytelnik3);
        biblioteka.wypozyczPozycje(czasopismo1, czytelnik1);
        biblioteka.stanKatalogu();
        biblioteka.zwrocPozycja(ksiazka1);
        biblioteka.stanKatalogu();
        biblioteka.zwrocPozycja(ksiazka1);
        biblioteka.stanKatalogu();
        biblioteka.usunPozycje(czasopismo1);
        biblioteka.stanKatalogu();
        biblioteka.wypozyczPozycje(czasopismo1, czytelnik2);
        biblioteka.stanKatalogu();
        biblioteka.usunPozycje(ksiazka1);
        biblioteka.stanKatalogu();
    }
}