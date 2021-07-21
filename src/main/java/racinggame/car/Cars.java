package racinggame.car;

import racinggame.util.RandomNumber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(Count count) {
        this.cars = initCars(count);
    }

    public static Cars manyOf(Count count) {
        return new Cars(count);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void race(RandomNumber randomNumber) {
        for (Car car : cars) {
            car.race(randomNumber.createBetweenZeroToNine());
        }
    }

    private List<Car> initCars(Count count) {
        int length = count.getCount();
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(new Car());
        }

        return list;
    }
}
