import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        Firma firma1= new Firma();
        Pracownik prac1 = new Pracownik("Bogdan","Nowak",34, Stanowisko.Dyrektor,5300);
        Pracownik prac2 = new Pracownik("Adam","Kowalski",24, Stanowisko.Zwyklak,2300);
        Pracownik prac3 = new Pracownik("Zbigniew","Dembiński",44, Stanowisko.Kierownik,3300);
        Pracownik prac4 = new Pracownik("Andrzej","Kowalczyk",44, Stanowisko.Zwyklak,2400);

        firma1.dodaj_pracownika(prac1);
        firma1.dodaj_pracownika(prac2);
        firma1.dodaj_pracownika(prac3);
        firma1.dodaj_pracownika(prac4);

        System.out.println(firma1.liczba_pracownikow());
        firma1.lista_pracownikow();

        for(Pracownik p: firma1){
            System.out.println(p.toString());
        }

        for (Iterator<Pracownik> iter = firma1.iterator(Stanowisko.Zwyklak); iter.hasNext(); ) {
            Pracownik p = iter.next();
            System.out.println(p.toString());

        }

        System.out.println(firma1.srednia_pensja());
        System.out.println(firma1.srednia_pensja(Stanowisko.Zwyklak));
    }
}
