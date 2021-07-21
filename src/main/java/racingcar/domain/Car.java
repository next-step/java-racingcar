package racingcar.domain;

public class Car {

    private int numberOfMove = 0;

    public Car() {

    }

    public void move(final int number) {
        if (isRange(number)) {
            this.numberOfMove++;
        }
    }

    private boolean isRange(final int random) {
        return random >= 4 && random < 10;
    }

    public int getNumberOfMove() {
        return this.numberOfMove;
    }
}
