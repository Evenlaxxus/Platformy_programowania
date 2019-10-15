public class Osoba {
    private final String imie;
    private final String nazwisko;
    private final int wiek;

    Osoba(String imie, String nazwisko, int wiek){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.wiek=wiek;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public String toString(){
        return "Imie: " + this.getImie() + "\nNazwisko: " + this.getNazwisko() + "\nWiek: " + this.getWiek() + "\n";
    }
}
