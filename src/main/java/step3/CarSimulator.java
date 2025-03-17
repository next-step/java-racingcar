package step3;

import java.util.ArrayList;
import java.util.List;

public class CarSimulator {
    private final int movementCount;
    private final List<Car> cars;
    private final List<CarPositions> history;

    public CarSimulator(int carCount, int movementCount) {
        this.movementCount = movementCount;
        this.cars = new ArrayList<>();
        this.history = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public CarPositions getPositions() {
        List<String> positionsList = new ArrayList<>();

        for (Car car : cars) {
            positionsList.add(car.getPosition());
        }

        return new CarPositions(positionsList);
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

    public List<CarPositions> getHistory() {
        return history;
    }

    private void saveHistory() {
        history.add(getPositions());
    }
}
