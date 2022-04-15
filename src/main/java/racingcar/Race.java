package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    public final List<Car> cars = new ArrayList<Car>();;

    public List<Car> createCars(String[] carNames) {
        for (String carName:carNames) {
            this.cars.add(new Car(carName));
        }
        return cars;
    }

    public static int getRandom() {
        return new Random().nextInt(10);
    }

    public static RolledResult roll(Car car) {
        int n = Race.getRandom();
        if (n < 4) {
            return new RolledResult(false, car);
        };
        car.move();
        return new RolledResult(true, car);
    }

    public void rollCars () {
        for (Car car:
             this.cars) {
            roll(car);
        }
    }
}
