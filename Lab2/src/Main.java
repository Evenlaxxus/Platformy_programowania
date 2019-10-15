import java.util.Iterator;

public class Main {
    private static void zad4(Firma firma1){
        System.out.println(firma1.liczba_pracownikow());
        firma1.lista_pracownikow();
    }
    private static void zad5(Firma firma1){
        for(Pracownik p: firma1){
            System.out.println(p.toString());
        }
    }
    private static void zad6(Firma firma1){
        for (Iterator<Pracownik> iter = firma1.iterator(Stanowisko.Zwyklak); iter.hasNext(); ) {
            Pracownik p = iter.next();
            System.out.println(p.toString());
        }
    }

    private static void zad7(Firma firma1){
        System.out.println(firma1.srednia_pensja());
        System.out.println(firma1.srednia_pensja(Stanowisko.Zwyklak));
    }

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

        zad4(firma1);
        zad5(firma1);
        zad6(firma1);
        zad7(firma1);
    }
}
