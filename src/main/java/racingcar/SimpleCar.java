package racingcar;

public class SimpleCar implements Car {
    private final static int MAX_CAR_NAME = 5;

    private String name;
    private Distance distance;

    public SimpleCar(String name) {
        verifyCarName(name);
        this.name = name;
        distance = new Distance();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Distance forward(MovementCondition movementCondition) {
        if (movementCondition.isMovable()) {
            distance = distance.increase();
        }
        return distance;
    }

    @Override
    public Distance getDistance() {
        return distance;
    }

    private void verifyCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("carName must be less then or equal to 5");
        }
    }
}
