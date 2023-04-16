package basicgame;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private static List<Car> cars;
    private final static int MAX_RANDOM = 10;

    public void activeCar() {
        for (Car car : cars) {
            car.go(RandomUtil.getRandomValue(MAX_RANDOM));
        }
    }

    public void initCar(int carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public int carsSize() {
        return cars.size();
    }

    public List<Vehicle> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
