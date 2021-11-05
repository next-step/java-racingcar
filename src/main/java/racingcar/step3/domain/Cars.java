package racingcar.step3.domain;

import racingcar.step3.move.Moving;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(int countOfCar) {
        for (int i = 0; i < countOfCar; i++) {
            cars.add(new Car());
        }
    }

    public void moveCars(Moving moving) {
        for (Car car : cars) {
            car.move(moving);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
