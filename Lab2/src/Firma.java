import java.util.Iterator;
import java.util.LinkedList;
import java.lang.Iterable;

public class Firma implements Iterable<Pracownik>{
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

    public double srednia_pensja(){
        double s=0;
        for(Pracownik p: this){
           s+=p.getPensja();

        }
        return s/this.liczba_pracownikow();
    }

    public double srednia_pensja(Stanowisko s){
        double sum=0;
        int licznik=0;
        for (Iterator<Pracownik> iter = this.iterator(s); iter.hasNext(); ) {
            Pracownik p = iter.next();
            sum+=p.getPensja();
            licznik++;
        }

        return sum/licznik;
    }

    @Override
    public Iterator<Pracownik> iterator() {
        return this.pracownicy.iterator();
    }

    public Iterator<Pracownik> iterator(Stanowisko s){
        return this.pracownicy.stream().filter(x->x.getStanowisko()==s).iterator();
    }
}
