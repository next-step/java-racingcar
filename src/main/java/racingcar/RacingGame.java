package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {
    private final int carQuantity;
    private final int movementCount;
    private List<Car> cars;

    private RacingGame(int carQuantity, int movementCount) {
        this.carQuantity = carQuantity;
        this.movementCount = movementCount;
        this.cars = initCars();
    }

    public static RacingGame ready(Input input) {
        return new RacingGame(input.getCarQuantity(), input.getMovementCount());
    }

    public static RacingGame ready(int carQuantity, int movementCount) {
        return new RacingGame(carQuantity, movementCount);
    }

    private List<Car> initCars() {
        cars = new ArrayList<>();
        for (int i = 0; i < this.carQuantity; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public RacingGame start() {
        cars.forEach(car -> car.tryMove(movementCount));
        return this;
    }

    public void result(Output output) {
        output.printResultMessage();
        cars.forEach(car -> output.printPosition(car.getPosition()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return carQuantity == that.carQuantity
                && movementCount == that.movementCount
                && cars.equals(that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carQuantity, movementCount, cars);
    }
}