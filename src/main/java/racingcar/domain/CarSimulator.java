package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarSimulator {
    private final Random random = new Random();
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
        List<CarPosition> positions = new ArrayList<>();

        for (Car car : cars) {
            positions.add(CarPosition.from(car));
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
            car.move(generateRandomNumber());
        }
    }

    private void saveHistory() {
        history.add(getPositions());
    }

    private int generateRandomNumber() {
        return random.nextInt(10);
    }
}
