package racingcar.domain;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private int number;

    public Position() {
        this.number = DEFAULT_POSITION;
    }

    public int getNumber() {
        return number;
    }

    public void move(final int moveCount) {
        this.number += moveCount;
    }
}
