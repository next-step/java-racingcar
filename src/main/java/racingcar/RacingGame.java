package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;

public class RacingGame {

    private final List<Car> cars;
    private final int tryCount;
    private final CarMover carMover = new CarMover();

    public RacingGame(int carCount, int tryCount) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
        this.tryCount = tryCount;
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public void moveAll(IntSupplier numbers) {
        for (Car car : cars) {
            carMover.move(car, numbers.getAsInt());
        }
    }

    public List<List<Integer>> race(IntSupplier numbers) {
        List<List<Integer>> history = new ArrayList<>();
        for (int turn = 0; turn < tryCount; turn++) {
            moveAll(numbers);
            history.add(positions());
        }
        return history;
    }

    private List<Integer> positions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }
}
