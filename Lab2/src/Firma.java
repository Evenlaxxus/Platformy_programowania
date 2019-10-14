import java.util.Iterator;
import java.util.LinkedList;
import java.lang.Iterable;

public class Firma implements Iterable{
    private LinkedList<Pracownik> pracownik;

    Firma(){
        this.pracownik=new LinkedList<Pracownik>();
    }
    public void dodaj_pracownika(Pracownik pracownik){
        this.pracownik.add(pracownik);
    }

    public int liczba_pracownikow(){
        return this.pracownik.size();
    }

    public void lista_pracownikow() {
        for(int i=0;i<this.liczba_pracownikow();i++){
            System.out.println(this.pracownik.get(i).toString());
        }
    }


    @Override
    public Iterator<Pracownik> iterator() {
        return this.pracownik.iterator();

    }
}
