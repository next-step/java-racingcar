package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    private final Random randomNumber = new Random();

    public Cars(String[] names) {
        addCar(names);
    }

    public void moveAll() {
        cars.forEach(car -> car.move(randomNumber.nextInt(10)));
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    private void addCar(String[] names) {
        for (String name : names) {
            cars.add(new Car(new CarName(name)));
        }
    }

    public List<Car> list() {
        return cars;
    }
}
