package racing.car;

public class Position {
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public int position() {
        return this.position;
    }

    public Position move(int offset) {
        int currentPosition = this.position;
        return new Position(currentPosition + offset);
    }
}
