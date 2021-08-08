package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final int MOVE_NUMBER = 4;

    public List<Car> initCars(int carCount) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < carCount; i++) {
            cars.add(new Car(MOVE_NUMBER));
        }

        return cars;
    }

    public void startRace(List<Car> cars) {
        Random random = new Random();

        for(Car car : cars) {
            car.move(random.nextInt(10));
        }
    }
}
