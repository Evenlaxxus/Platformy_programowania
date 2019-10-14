public class Main {
    public static void main(String[] args){
        Firma firma1= new Firma();
        Pracownik prac1 = new Pracownik("Bogdan","Nowak",34, Stanowisko.Dyrektor,5300);
        Pracownik prac2 = new Pracownik("Adam","Kowalski",24, Stanowisko.Pracownik,2300);
        Pracownik prac3 = new Pracownik("Zbigniew","Dembiński",44, Stanowisko.Kierownik,3300);

        firma1.dodaj_pracownika(prac1);
        firma1.dodaj_pracownika(prac2);
        firma1.dodaj_pracownika(prac3);

        System.out.println(firma1.liczba_pracownikow());
        firma1.lista_pracownikow();

        for(Object p: firma1){
            System.out.println(p.toString());
        }

    }
}
