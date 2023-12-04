package racingcar.model;

public class Position {
    private static final int START_POSITION = 0;
    private static final int STEP = 1;
    private final int position;

    public Position() {
        this.position = START_POSITION;
    }

    public Position(int value) {
        this.position = value;
    }

    public int step() {
        return this.position + STEP;
    }

    public int biggerPosition(int position) {
        if (this.position > position) {
            return this.position;
        }
        return position;
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }

    public int position() {
        return this.position;
    }

    @Override
    public boolean equals(Object obj) {
        Position other = (Position) obj;
        if (this.position == other.position) {
            return true;
        }
        return false;
    }
}
