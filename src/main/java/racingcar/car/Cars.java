package racingcar.car;

import racingcar.random.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private final RandomNumberGenerator randomNumberGenerator;

    public Cars(int numberOfCars, RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            int randomDistance = randomNumberGenerator.generate();
            car.move(randomDistance);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
