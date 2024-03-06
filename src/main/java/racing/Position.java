package racing;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void add(int addend) {
        position += addend;
    }
}
