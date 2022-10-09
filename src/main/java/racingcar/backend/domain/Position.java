package racingcar.backend.domain;

public class Position {

    private static final int INITIAL_POSITION = 0;
    private int value;

    public Position() {
        this(INITIAL_POSITION);
    }

    public Position(int position) {
        this.value = position;
    }

    public static Position create() {
        return new Position();
    }

    public static Position create(int position) {
        return new Position(position);
    }

    public void forward() {
        value++;
    }

    public int getValue() {
        return this.value;
    }
}
