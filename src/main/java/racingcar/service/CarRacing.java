package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars;

    public CarRacing(List<String> carNames) {
        carRaceReady(carNames);
    }

    private void carRaceReady(List<String> carNames) {
        cars = new ArrayList<Car>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> carRaceStart() {
        for (Car car : cars) {
            car.move(RandomNumber.make());
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}

