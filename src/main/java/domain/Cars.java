package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(int numberOfCars) {
        generateCars(numberOfCars);
    }

    private void generateCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car : this.cars) {
            car.move(numberGenerator);
        }
    }

    public List<Position> getCurrentPositions() {
        List<Position> positions = new ArrayList<>();
        for (Car car : this.cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }
}
