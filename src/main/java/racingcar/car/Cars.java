package racingcar.car;

import racingcar.engine.PowerEngine;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;
    private PowerEngine powerEngine;

    private Cars(CountOfCars countOfCars, PowerEngine powerEngine) {
        this.powerEngine = powerEngine;
        this.cars = registerCars(countOfCars);
    }

    private List<Car> registerCars(CountOfCars countOfCars) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < countOfCars.getCount(); i++) {
            cars.add(Car.newInstance(this.powerEngine));
        }

        return cars;
    }

    public static Cars newInstance(CountOfCars countOfCars, PowerEngine powerEngine) {
        return new Cars(countOfCars, powerEngine);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> move() {
        for (Car car : cars) {
            car.move();
        }

        return getCars();
    }
}
