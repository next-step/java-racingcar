package racingcar.backend.domain;

public class Position implements Cloneable {

    private static final int INITIAL_POSITION = 0;
    private int value;

    public Position() {
        this(INITIAL_POSITION);
    }

    public Position(int position) {
        this.value = position;
    }

    public void forward() {
        value++;
    }

    public int getValue() {
        return this.value;
    }
}
