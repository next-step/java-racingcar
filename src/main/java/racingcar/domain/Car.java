package racingcar.domain;

public class Car {

    private Name name;
    private int numberOfMove = 0;

    public Car(final String name) {
        this.name = Name.from(name);
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

    public Name getName() {
        return name;
    }
}
