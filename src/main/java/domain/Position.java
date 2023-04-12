package domain;

public enum Position {
    ZERO(0),
    ONE(1);

    final int position;
    Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
