package carracingwinner.domain;

import carracingwinner.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName, new Position(0)));
        }
    }

    public Result move() {
        cars.forEach(car -> car.move(RandomUtils.randomInt()));
        return new Result(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

}
