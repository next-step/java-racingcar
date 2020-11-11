package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(int participationCars) {
        createCars(participationCars);
    }

    private void createCars(int participationCars) {
        for (int i = 0; i < participationCars; i++) {
            cars.add(new Car());
        }
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }
}
