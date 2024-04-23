package rs.nmarinkovic.combinations;

public class MyPair
{
    private int index;
    private String value;

    public MyPair(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public MyPair() {
        this.index = -1;
        this.value = "trashvalue";
    }

    public MyPair(MyPair p) {
        this.index = p.index;
        this.value = p.value;
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }
}
