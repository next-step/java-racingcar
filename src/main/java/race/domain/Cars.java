package race.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int numberOfCars) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public List<Integer> goForward() {
        List<Integer> mileages = new ArrayList<>();
        for (Car car : cars) {
            car.go();
            mileages.add(car.getPosition());
        }
        return mileages;
    }

}
