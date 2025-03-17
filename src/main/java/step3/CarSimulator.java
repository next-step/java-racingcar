package step3;

import java.util.ArrayList;
import java.util.List;

public class CarSimulator {
    private int movementCount;
    private List<Car> cars;

    public void init(int carCount, int movementCount) {
        this.movementCount = movementCount;
        this.cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public List<String> getPositions() {
        List<String> positions = new ArrayList<>();

        for (Car car : cars) {
            positions.add(car.getPosition());
        }

        return positions;
    }

    public void simulate() {
        for (int i = 0; i < movementCount; i++) {
            moveAllCars();
        }
    }

    private void moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
