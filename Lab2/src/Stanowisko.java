public enum Stanowisko{
        Dyrektor("Dyrektor",1,"Dyrekor firmy"),
        Kierownik("Kierownik",2,"Kierownik zmiany"),
        Zwyklak("Zwyklak",3,"Zwykły pracownik");

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

