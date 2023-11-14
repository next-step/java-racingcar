package car.domain;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        this.position++;
    }

    public int carPosition() {
        return this.position;
    }

    public boolean isSameMax(int max) {
        return this.position == max;
    }

    public int compareCarPosition(int max) {
        return Math.max(this.position, max);
    }
}
