package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import racingcar.domain.car.Car;

public class Participants {

    private final String[] carNames;
    private final List<Car> cars = new ArrayList<>();

    public Participants(String[] names) {
        this.carNames = names;
        createCars();
    }

    private void createCars() {
        for (String name : this.carNames) {
            Car car = Car.from(name);
            cars.add(car);
        }
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public int count() {
        return cars.size();
    }

    public Stream<Car> getWinners() {
        Collections.sort(cars);
        Car winner = cars.get(0);
        return cars.stream().filter(car -> car.compareStatus(winner));
    }
}
