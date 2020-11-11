package racing;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int participationCars) {
        this.cars = createCars(participationCars);
    }

    private List<Car> createCars(int participationCars) {
        for (int i = 0; i < participationCars; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
