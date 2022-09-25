package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
    private List<Car> cars = new ArrayList<>();

    public RacingCar(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> racing() {
        for (Car car : cars) {
            car.move(createRandomNumber());
        }
        return cars;
    }

    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public List<Car> getCars() {
        return cars;
    }
}
