package domain;

import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars = new ArrayList();

    private final Random random = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;

    public Cars(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
    }

    public void race() {
        for (Car car : cars) {
            int randomNumber = random.nextInt(RANDOM_NUMBER_BOUND);
            car.move(randomNumber);
        }
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }
}
