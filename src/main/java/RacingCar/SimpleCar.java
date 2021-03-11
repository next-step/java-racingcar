package RacingCar;

public class SimpleCar implements Car {
    private final int MAX_CAR_NAME = 5;

    private String name;
    private int distance = 0;

    public SimpleCar(String name) {
        verifyCarName(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public int forward(MovementCondition movementCondition) {
        if (movementCondition.isMovable()) {
            ++distance;
        }
        return distance;
    }

    private void verifyCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("carName must be less then or equal to 5");
        }
    }
}
