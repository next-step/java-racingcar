package racingcar.service;

import racingcar.model.number.Number;
import racingcar.model.race.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private final List<Car> cars = new ArrayList<Car>();

    public CarRacing(List<String> carNames) {
        carRaceReady(carNames);
    }

    private void carRaceReady(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> carRaceStart(Number number) {
        for (Car car : cars) {
            car.move(number.make());
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}

