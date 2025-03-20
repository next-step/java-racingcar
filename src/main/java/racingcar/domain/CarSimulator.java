package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarSimulator {
    private final int movementCount;
    private final List<Car> cars;
    private final List<CarPositions> history;

    public CarSimulator(int movementCount, List<Car> cars) {
        this.movementCount = movementCount;
        this.cars = cars;
        this.history = new ArrayList<>();
    }

    public List<CarPositions> getHistory() {
        return history;
    }

    public CarPositions getPositions() {
        List<Integer> positions = new ArrayList<>();

        for (Car car : cars) {
            positions.add(car.getPosition());
        }

        return new CarPositions(positions);
    }

    public void simulate() {
        for (int i = 0; i < movementCount; i++) {
            moveAllCars();
            saveHistory();
        }
    }

    private void moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void saveHistory() {
        history.add(getPositions());
    }
}
