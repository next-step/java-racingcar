package carracing.domain;

public class Position {

    private int position;

    public Position() {
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }
}
