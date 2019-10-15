public enum Stanowisko{
        Dyrektor("Dyrektor",1,"Pan i władca tego serwera"),
        Kierownik("Kierownik",1,"Przydupas dyrektora"),
        Zwyklak("Zwyklak",1,"Niewolnik");

    private final String nazwa;
    private final int poziom;
    private final String opis;
    Stanowisko(String nazwa, int poziom, String opis){
        this.nazwa=nazwa;
        this.poziom=poziom;
        this.opis=opis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getPoziom() {
        return poziom;
    }

    public String getOpis() {
        return opis;
    }
}

