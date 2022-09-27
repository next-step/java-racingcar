package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
    private List<Car> cars = new ArrayList<>();

    public RacingCar(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
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
