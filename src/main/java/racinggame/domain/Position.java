package racinggame.domain;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        position = position + 1;
    }

    public int getPosition() {
        return position;
    }

}
