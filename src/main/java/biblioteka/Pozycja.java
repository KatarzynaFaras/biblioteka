package biblioteka;

import java.util.Objects;

public class Pozycja {

    private TypPozycji typPozycji;
    private String tytol;
    private String autor;
    private Status status = Status.DOSTEPNA;
    private Czytelnik aktualnyCzytelnik;

    public void setAktualnyCzytelnik(Czytelnik aktualnyCzytelnik) {
        this.aktualnyCzytelnik = aktualnyCzytelnik;
    }

    public Czytelnik getAktualnyCzytelnik() {
        return aktualnyCzytelnik;
    }

    public Pozycja(TypPozycji typPozycji, String tytol, String autor) {
        this.typPozycji = typPozycji;
        this.tytol = tytol;
        this.autor = autor;
    }

    public Pozycja(TypPozycji typPozycji, String tytol) {
        this.typPozycji = typPozycji;
        this.tytol = tytol;
        this.autor = "";
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return typPozycji + ": " + tytol + "  " + autor + "\n" +
                " - " + status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pozycja pozycja = (Pozycja) o;
        return typPozycji == pozycja.typPozycji &&
                Objects.equals(tytol, pozycja.tytol) &&
                Objects.equals(autor, pozycja.autor) &&
                status == pozycja.status &&
                Objects.equals(aktualnyCzytelnik, pozycja.aktualnyCzytelnik);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typPozycji, tytol, autor, status, aktualnyCzytelnik);
    }
}
