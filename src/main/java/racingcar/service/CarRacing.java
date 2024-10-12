package racingcar.service;

import racingcar.model.maker.NumberMaker;
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

    public List<Car> carRaceStart(NumberMaker numberMaker) {
        for (Car car : cars) {
            car.move(numberMaker.make());
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}

