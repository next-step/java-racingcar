package racing.domain;

import racing.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private final List<Car> cars = new ArrayList<>();

    public int getNumberOfCars() {
        return this.cars.size();
    }

    public List<Car> createCars(String nameInput) {
        String[] names = StringUtil.split(nameInput);

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }

        return this.cars;
    }

}
