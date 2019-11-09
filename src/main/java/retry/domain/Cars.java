package retry.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int PIVOT_NUMBER = 4;
    private static final int RANDOM_BOUND_NUMBER = 9;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean contains(Car car) {
        return this.cars.contains(car);
    }

    public Cars moveCarsPositionByInterface() {
        List<Car> carsWithPosition = new ArrayList<>();
        for (Car car : this.cars) {
            carsWithPosition.add(car.move(() -> getRandomNumber() >= PIVOT_NUMBER));
        }
        return new Cars(carsWithPosition);
    }

    public List<Car> getCars() {
        return cars;
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_BOUND_NUMBER);
    }

}
