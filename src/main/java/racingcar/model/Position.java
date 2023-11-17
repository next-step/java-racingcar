package racingcar.model;

public class Position {
    private static final int START_POSITION = 0;
    private static final int STEP = 1;

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

    public int diff(Position other) {
        System.out.println(other.position);
        return this.position - other.position;
    }

    public String mark(String mark) {
        String resultMark = "";
        for (int i = 0; i<position; i++) {
            resultMark += mark;
        }
        return resultMark;
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
