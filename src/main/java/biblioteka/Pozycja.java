package biblioteka;

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
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        if (typPozycji == TypPozycji.KSIAZKA) {
            return typPozycji + ": " + tytol + ", " + autor + "\n" +
                    " - " + status;
        } else {
            return typPozycji + ": " + tytol + "\n" +
                    " - " + status;
        }
    }
}
