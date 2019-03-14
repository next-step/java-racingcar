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

        List<Car> movedCars = new ArrayList<>();

        for (Car car : cars) {
            boolean isMoved = car.move();
            storeRoundHistory(movedCars, car, isMoved);
        }

        return this.cars;
    }

    public void storeRoundHistory(List<Car> movedCars, Car car, boolean isMoved) {
        if (isMoved) {
            movedCars.add(car);
        }
    }
}
