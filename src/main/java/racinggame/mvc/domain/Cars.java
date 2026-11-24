package racinggame.mvc.domain;

import java.util.ArrayList;
import java.util.List;

public final class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> farthestCars() {
        List<Car> farthestCars = new ArrayList<>();
        int farthestPosition = Integer.MIN_VALUE;
        for (Car car : cars) {
            int position = car.getPosition();
            if (position > farthestPosition) {
                farthestPosition = position;
                farthestCars.clear();
            }
            if (position == farthestPosition) {
                farthestCars.add(car);
            }
        }
        return List.copyOf(farthestCars);
    }
}
