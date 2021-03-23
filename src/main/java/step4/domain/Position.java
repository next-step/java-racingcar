package step4.domain;

public class Position {

    int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void plus() {
        position++;
    }
}
