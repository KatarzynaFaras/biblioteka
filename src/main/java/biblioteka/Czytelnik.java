package biblioteka;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Czytelnik czytelnik = (Czytelnik) o;
        return Objects.equals(imię, czytelnik.imię) &&
                Objects.equals(nazwisko, czytelnik.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imię, nazwisko);
    }
}
