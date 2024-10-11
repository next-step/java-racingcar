package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars;

    public CarRacing(String[] carNames) {
        carRaceReady(carNames);
    }

    private void carRaceReady(String[] carNames) {
        cars = new ArrayList<Car>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> carRaceStart() {
        for (Car car : cars) {
            car.move();
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}

