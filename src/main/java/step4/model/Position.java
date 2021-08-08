package step4.model;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        this.position += 1;
    }
}
