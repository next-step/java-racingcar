package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private List<Car> cars;

    public RacingCarGame() {
    }

    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> createCars(String[] names) {
        cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public List<Car> startRound(List<Car> cars) {
        this.cars = cars;
        for (Car car : cars) {
            car.move();
        }

        return this.cars;
    }
}
