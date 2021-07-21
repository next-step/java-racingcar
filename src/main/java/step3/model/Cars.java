package step3.model;

import step3.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    protected Cars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public static Cars of(int carCount) {
        return new Cars(carCount);
    }

    public void move(Random random) {
        cars.forEach(car -> car.moveIf(random.nextInt(App.RANGE_MAX)));
    }

    public int countOfCars() {
        return cars.size();
    }

    public List<Integer> getPointOfCarsByTime(int time) {
        return cars.stream()
            .map(car -> car.getPointOfTime(time))
            .collect(Collectors.toList());
    }
}
