package biblioteka;

public class Czytelnik {

    private String imię;
    private String nazwisko;

    public Czytelnik(String imię, String nazwisko) {
        this.imię = imię;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return imię + " " + nazwisko;
    }
}
