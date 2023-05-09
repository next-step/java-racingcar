package domain;

public enum Position {
    START(1),
    STOP(0),
    MOVE(1);

    final int position;

    Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
