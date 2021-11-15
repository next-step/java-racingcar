package carracingwinner.domain;

import carracingwinner.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        this(new ArrayList<>());
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move(RandomUtils.randomInt()));
    }

    public List<String> getLastWinners() {
        int max = cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
