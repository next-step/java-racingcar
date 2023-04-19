package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private final List<Car> cars;
    private final Random randomNumber = new Random();

    public Cars(int number) {
        cars = new ArrayList<>();
        addCar(number);
    }

    public void moveAll() {
        cars.forEach(car -> {
            car.move(randomNumber.nextInt(10));
        });
    }

    public int size() {
        return cars.size();
    }

    private void addCar(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> list() {
        return cars;
    }
}
