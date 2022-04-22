package model;

public class Position {

    private int position;

    public void plus() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public Position(int position) {
        this.position = position;
    }
}
