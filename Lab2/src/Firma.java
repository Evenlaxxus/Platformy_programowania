import java.util.Iterator;
import java.util.LinkedList;
import java.lang.Iterable;

public class Firma implements Iterable{
    private LinkedList<Pracownik> pracownicy;

    Firma(){
        this.pracownicy=new LinkedList<Pracownik>();
    }
    public void dodaj_pracownika(Pracownik pracownik){
        this.pracownicy.add(pracownik);
    }

    public int liczba_pracownikow(){
        return this.pracownicy.size();
    }

    public void lista_pracownikow() {
        for(int i=0;i<this.liczba_pracownikow();i++){
            System.out.println(this.pracownicy.get(i).toString());
        }
    }


    @Override
    public Iterator<Pracownik> iterator() {
        return this.pracownicy.iterator();

    }
    
}
