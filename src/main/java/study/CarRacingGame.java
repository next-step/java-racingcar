package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class CarRacingGame {

    private List<Car> cars;
    private int numberOfAttempts;

    CarRacingGame() {
        cars = new ArrayList<>();
        setUp();
    }

    private void setUp() {
        Map<String, Integer> configuration = InputView.getConfiguration();
        int numberOfCars = configuration.get("numberOfCars");
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        this.numberOfAttempts = configuration.get("numberOfAttempts");
    }

    private void print() {
        ResultView.print(cars);
    }

    void start() {
        for (int i = 0; i < numberOfAttempts; i ++) {
            cars.forEach(Car::move);
            print();
        }
    }

}
