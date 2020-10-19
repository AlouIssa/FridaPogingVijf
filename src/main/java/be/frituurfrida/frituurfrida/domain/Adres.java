package be.frituurfrida.frituurfrida.domain;

public class Adres {
    private final String straat, huisnr;
    private final Gemeente gemeente;

    public Adres(String straat, String huisnr, Gemeente gemeente) {
        this.straat = straat;
        this.huisnr = huisnr;
        this.gemeente = gemeente;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisnr() {
        return huisnr;
    }

    public Gemeente getGemeente() {
        return gemeente;
    }
}
