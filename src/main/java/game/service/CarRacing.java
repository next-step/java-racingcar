package game.service;

import game.domain.Car;
import game.domain.Cars;

import java.util.List;

public class CarRacing {

    private final Cars cars;

    public CarRacing(List<String> carNames) {
        this.cars = new Cars(carNames);
    }

    public void start() {
        cars.drive();

    }

    public Cars getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }

}