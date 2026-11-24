package racinggame.winner;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.nextNumber());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getFarthestCars() {
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

        return farthestCars;
    }
}
