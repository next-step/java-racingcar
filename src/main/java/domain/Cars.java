package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] nameOfCars) {
        generateCars(nameOfCars);
    }

    private void generateCars(String[] nameOfCars) {
        for (String name : nameOfCars) {
            this.cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        Position maxPosition = new Position(0);
        for (Car car : cars) {
            Position position = car.getCurrentPosition();
            if (position.compareTo(maxPosition) >= 0) {
                maxPosition = position;
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
