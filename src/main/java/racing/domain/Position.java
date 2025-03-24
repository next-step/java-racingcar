package racing.domain;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        this.position += 1;
    }

    public int max(int other) {
        return Math.max(this.position, other);
    }

    public boolean isSamePosition(int other) {
        return this.position == other;
    }

    public int getPositionForDisplay() {
        return this.position;
    }
}
