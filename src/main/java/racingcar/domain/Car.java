package racingcar.domain;

public class Car implements Cloneable {

    private static final int STANDARD_CAR_NAME_LENGTH = 5;

    private String name;
    private int moveCount = 0;

    public Car(String carName) {
        if (carName.length() > STANDARD_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(String
                    .format("Input Car name : %s, car name must be less than 6 characters.", carName));
        }
        name = carName;
    }

    public Car(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public Car stopOrMove(Strategy strategy) {
        if (strategy.isMovable()) {
            return new Car(name, moveCount + 1);
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
