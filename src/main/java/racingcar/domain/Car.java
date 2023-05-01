package racingcar.domain;

import racingcar.generator.NumberGenerator;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    public static final String CAR_MOVEMENT_SINGLE_STEP = "-";
    private final Name name;
    private MovementCount movementCount;

    public Car(String carName) {
        this.name = new Name(carName);
        this.movementCount = new MovementCount();
    }

    public Car(String carName, int movementCount) {
        this.name = new Name(carName);
        this.movementCount = new MovementCount(movementCount);
    }

    public int getMovementCount() {
        return movementCount.getMovementCount();
    }

    public String getCarName() {
        return name.getCarName();
    }

    public void move(NumberGenerator numberGenerator) {
        movementCount.move(numberGenerator);
    }

    public boolean isWinnerMovementCount(int movementCount) {
        return this.movementCount.isWinnerMovementCount(movementCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name.getCarName(), car.name.getCarName())
                && Objects.equals(movementCount.getMovementCount(), car.movementCount.getMovementCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, movementCount);
    }

    @Override
    public String toString() {
        String movementStep = IntStream.range(0, getMovementCount())
                .mapToObj(i -> CAR_MOVEMENT_SINGLE_STEP)
                .collect(Collectors.joining());
        return getCarName() + ":" + movementStep;
    }
}
