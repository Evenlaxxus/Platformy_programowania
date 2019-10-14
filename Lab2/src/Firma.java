import java.util.LinkedList;
import java.lang.Iterable;

public class Firma{
    private LinkedList<Pracownik> pracownik;

    public void dodaj_pracownika(Pracownik pracownik){
        this.pracownik.add(pracownik);
    }

    public int liczba_pracownikow(){
        return this.pracownik.size();
    }

    public LinkedList<Pracownik> getPracownik() {
        return pracownik;
    }

}
