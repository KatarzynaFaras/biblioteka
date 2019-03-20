package biblioteka.biblioteka;

import biblioteka.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BibliotekaTest {


    public Biblioteka biblioteka;

    @Before
    public void setUp() throws Exception {
        this.biblioteka = new Biblioteka();
        this.biblioteka.dodajPozycja(new Pozycja(TypPozycji.KSIAZKA, "Hobbit", "Tolkien"));
        this.biblioteka.dodajPozycja(new Pozycja(TypPozycji.KSIAZKA, "Hobbit2", "Tolkien"));
        this.biblioteka.dodajPozycja(new Pozycja(TypPozycji.KSIAZKA, "Hobbit3", "Tolkien"));
        this.biblioteka.dodajCzytelnik(new Czytelnik("Roman", "Rura"));
        this.biblioteka.dodajCzytelnik(new Czytelnik("Roman", "Noga"));
        this.biblioteka.wypozyczPozycje(this.biblioteka.getKatalog().get(1),this.biblioteka.getCzytelnicy().get(0));
    }

    @Test
    public void dodajPozycja() {
        Assert.assertEquals(this.biblioteka.getKatalog().size(),3);

        this.biblioteka.dodajPozycja(new Pozycja(TypPozycji.KSIAZKA, "Hobbit4", "Tolkien"));
        Assert.assertEquals(this.biblioteka.getKatalog().size(),4);
    }

    @Test
    public void usunPozycje() {

        this.biblioteka.usunPozycje(biblioteka.getKatalog().get(0));
        Assert.assertEquals(this.biblioteka.getKatalog().size(),2);
    }

    @Test
    public void zwrocPozycja() {
        this.biblioteka.zwrocPozycja(this.biblioteka.getKatalog().get(1));

        Assert.assertEquals(this.biblioteka.getKatalog().get(1).getStatus(), Status.DOSTEPNA);
        Assert.assertEquals(this.biblioteka.getKatalog().get(1).getAktualnyCzytelnik(), null);

    }

    @Test
    public void wypozyczPozycje() {
        Assert.assertEquals(this.biblioteka.getKatalog().get(0).getStatus(), Status.DOSTEPNA);
        Assert.assertEquals(this.biblioteka.getKatalog().get(0).getAktualnyCzytelnik(), null);

        this.biblioteka.wypozyczPozycje(this.biblioteka.getKatalog().get(0),this.biblioteka.getCzytelnicy().get(1));

        Assert.assertEquals(this.biblioteka.getKatalog().get(0).getStatus(), Status.WYPOZYCZONA);
        Assert.assertEquals(this.biblioteka.getKatalog().get(0).getAktualnyCzytelnik(), this.biblioteka.getCzytelnicy().get(1));

    }

    @Test
    public void dodajCzytelnik() {
        Assert.assertEquals(biblioteka.getCzytelnicy().size(), 2);
        biblioteka.dodajCzytelnik(new Czytelnik("Adrian", "Ręka"));
        Assert.assertEquals(biblioteka.getCzytelnicy().size(),3);
    }

    @Test
    public void stanKatalogu() {
    }
}