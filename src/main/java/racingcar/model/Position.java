package racingcar.model;

public class Position {
    private static final int START_POSITION = 0;
    private static final int STEP = 1;
    private static final String LOCATION_MARK = "-";

    private int position;

    public Position() {
        this.position = START_POSITION;
    }

    public Position(int value) {
        this.position = value;
    }

    public void step() {
        this.position += STEP;
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

    @Override
    public String toString() {
        String mark = "";
        for (int i = 0; i<position; i++) {
            mark += LOCATION_MARK;
        }
        return mark;
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
