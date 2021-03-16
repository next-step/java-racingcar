package step3.service;

import step3.domain.Car;
import step3.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int numberOfCars;
    private final int attemps;

    public RacingGame(int numberOfCars, int attemps) {
        this.numberOfCars = numberOfCars;
        this.attemps = attemps;
    }

    public List<Car> setCars() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void start(Cars cars) {
        for (int i = 0; i < numberOfCars; i++) {
            Car car = cars.getCars().get(i);
            car.move(new GameRule());
        }
    }

    public int getAttemps() {
        return attemps;
    }

}
