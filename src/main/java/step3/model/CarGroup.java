package step3.model;

import step3.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarGroup {
    private final List<Car> cars = new ArrayList<>();

    public CarGroup(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void move(Random random) {
        cars.forEach(car ->
                car.moveIf(random.nextInt(App.RANGE))
        );
    }

    public void show() {
        cars.forEach(Car::show);
    }

    public int countOfCars() {
        return cars.size();
    }
}
