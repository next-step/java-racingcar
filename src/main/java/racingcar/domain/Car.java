package racingcar.domain;

public class Car {

    private String name;
    private int numberOfMove = 0;

    public Car(String name) {
        this.name = name;
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
