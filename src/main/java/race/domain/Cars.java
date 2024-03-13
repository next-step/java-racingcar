package race.domain;

import race.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int numberOfCars, String[] names) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(0, names[i]));
        }
    }

    public List<Integer> goForward(RandomUtil rule) {
        List<Integer> mileages = new ArrayList<>();
        for (Car car : cars) {
            car.go(rule.generate());
            mileages.add(car.getPosition());
        }
        return mileages;
    }

}
