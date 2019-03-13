package biblioteka;

import java.util.ArrayList;
import java.util.List;

public class Biblioteka {

    private static List<Pozycja> katalog = new ArrayList<>();
    private static List<Czytelnik> czytelnicy = new ArrayList<>();

    public static void stanKatalogu() {
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

    public static void dodajPozycja(Pozycja p) {
        katalog.add(p);
    }

    public static void usunPozycje(Pozycja p) {
        if (p.getStatus() == Status.DOSTEPNA) {
            katalog.remove(p);
        }
    }

    public static void zwrocPozycja(Pozycja p) {
        if (p.getStatus() == Status.DOSTEPNA) {
            System.out.println("Pozycja nie jest wypożyczona." + "\n");
        } else {
            p.setStatus(Status.DOSTEPNA);
            p.setAktualnyCzytelnik(null);
        }
    }

    public static void wypozyczPozycje(Pozycja p, Czytelnik cz) {
        if (p.getStatus() == Status.DOSTEPNA) {
            p.setStatus(Status.WYPOZYCZONA);
            p.setAktualnyCzytelnik(cz);
        } else {
            System.out.println("Pozycja jest aktulnie wypożyczona przez kogoś innego." + "\n");
        }
    }

    public static void main(String[] args) {

        Czytelnik czytelnik1 = new Czytelnik("Marcin", "Faraś");
        Czytelnik czytelnik2 = new Czytelnik("Tomasz", "Noga");
        Czytelnik czytelnik3 = new Czytelnik("Mariusz", "Oko");

        czytelnicy.add(czytelnik1);
        czytelnicy.add(czytelnik2);
        czytelnicy.add(czytelnik3);

        Pozycja ksiazka1 = new Pozycja(TypPozycji.KSIAZKA, "Hobbit", "Tolkien");
        Pozycja ksiazka2 = new Pozycja(TypPozycji.KSIAZKA, "Grom", "Petelicki");
        Pozycja czasopismo1 = new Pozycja(TypPozycji.CZASOPISMO, "Travel");
        Pozycja czasopismo2 = new Pozycja(TypPozycji.CZASOPISMO, "National Geographic");

        dodajPozycja(ksiazka1);
        dodajPozycja(ksiazka2);
        dodajPozycja(czasopismo1);
        dodajPozycja(czasopismo2);

        stanKatalogu();
        wypozyczPozycje(ksiazka1, czytelnik3);
        wypozyczPozycje(czasopismo1, czytelnik1);
        stanKatalogu();
        zwrocPozycja(ksiazka1);
        stanKatalogu();
        zwrocPozycja(ksiazka1);
        stanKatalogu();
        usunPozycje(czasopismo1);
        stanKatalogu();
        wypozyczPozycje(czasopismo1, czytelnik2);
        stanKatalogu();
        usunPozycje(ksiazka1);
        stanKatalogu();
    }
}