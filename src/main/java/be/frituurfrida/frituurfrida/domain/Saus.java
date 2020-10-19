package be.frituurfrida.frituurfrida.domain;

public class Saus {
    private final int id;
    private final String naam;
    private final String[] ingredienten;

    public Saus(int id, String naam, String[] ingredienten) {
        this.id = id;
        this.naam = naam;
        this.ingredienten = ingredienten;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String[] getIngredienten() {
        return ingredienten;
    }
}
