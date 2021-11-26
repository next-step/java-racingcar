package racinggame.domain;

public class Position {
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public int getPosition() {
        return position;
    }

    public boolean isSame(int maxPosition) {
        return this.position == maxPosition;
    }

    public boolean isBiggerThan(int maxPosition) {
        return this.position > maxPosition;
    }
}
