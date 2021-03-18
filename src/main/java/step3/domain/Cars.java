package step3.domain;

import step3.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames) {
        this(makeCars(carNames));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private static List<Car> makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveForward(RandomUtil.makeRandomNumber(), num -> num >= 4);
        }
    }
}
