package edu.nextstep.camp;

public class Position {
    private int position;

    public static Position of(int position) {
        return new Position(position);
    }

    private Position(int position) {
        this.position = position;
    }

    public void forward() {
        this.position++;
    }

    public int toInt() {
        return position;
    }
}
