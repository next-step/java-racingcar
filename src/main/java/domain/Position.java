package domain;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position++;
    }
}
