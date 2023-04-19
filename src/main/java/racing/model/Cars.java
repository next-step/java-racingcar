package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(int number) {
        cars = new ArrayList<>();
        createCars(number);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> createCars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
