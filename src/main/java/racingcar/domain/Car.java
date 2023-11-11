package racingcar.domain;

public class Car implements Cloneable {

    private static final int STANDARD_CAR_NAME_LENGTH = 5;

    private String name;
    private int moveCount = 0;

    public Car(String carName) {
        if (carName.length() > STANDARD_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("Car name must be less than 6 characters.");
        }
        name = carName;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void stopOrMove(Strategy strategy) {
        if (strategy.isMovable()) {
            moveCount += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
