package car;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        Random random = new Random();
        for(Car car: cars) {
            int randomNumber = random.nextInt(10);
            car.move(randomNumber);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
