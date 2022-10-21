package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MOVABLE_THRESHOLD = 4;

    private final CarName name;

    private final Position position = new Position();

    private Car(CarName name) {
        this.name = name;
    }

    public static Car nameOf(String name) throws IllegalArgumentException {
        return new Car(CarName.valueOf(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getPosition() == car.getPosition() && getName().equals(car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition(), getName());
    }

    public void moveForward(NumberStrategy numberStrategy) {
        if (isMovable(numberStrategy)) {
            position.move();
        }
    }

    private boolean isMovable(NumberStrategy numberStrategy) {
        return numberStrategy.isSameOrOverThreshold(Car.MOVABLE_THRESHOLD);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isSamePosition(int position) {
        return this.position.isSamePosition(position);
    }

    public String getName() {
        return name.getName();
    }
}
