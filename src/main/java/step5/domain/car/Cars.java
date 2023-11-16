package step5.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars defaultOf(String names) {
        List<Car> cars = new ArrayList<>();
        String[] nameArray = names.split(",");

        for (String name: nameArray) {
            cars.add(Car.defaultOf(name));
        }

        return new Cars(cars);
    }

    public boolean hasSize(int questionSize) {
        return cars.size() == questionSize;
    }
}
