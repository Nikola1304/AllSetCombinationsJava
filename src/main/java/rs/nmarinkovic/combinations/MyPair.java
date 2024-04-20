package rs.nmarinkovic.combinations;

public class MyPair
{
    private int indeks;
    private String vrednost;

    public MyPair(int indeks, String vrednost) {
        this.indeks = indeks;
        this.vrednost = vrednost;
    }

    public MyPair() {
        this.indeks = -1;
        this.vrednost = "trashvalue";
    }

    public MyPair(MyPair p) {
        this.indeks = p.indeks;
        this.vrednost = p.vrednost;
    }

    public int getIndeks() {
        return indeks;
    }

    public String getVrednost() {
        return vrednost;
    }
}
