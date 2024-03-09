package domain;

public class Position {

    private int x;

    public Position() {
        this(0);
    }

    public Position(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void forward() {
        this.x++;
    }
}
