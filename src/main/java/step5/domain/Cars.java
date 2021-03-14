package step5.domain;


import step5.utils.RandomGenerator;

import java.util.List;
import java.util.TreeMap;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Cars {

    public static final int START_POSITION = 1;

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(carName -> new Car(carName, START_POSITION))
                .collect(toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return cars.stream()
                .collect(groupingBy(car -> {
                    Position position = car.getPosition();
                    return position.getPosition();
                }, TreeMap::new, toList()))
                .lastEntry()
                .getValue();
    }

    public void move(RandomGenerator random) {
        cars.forEach(car -> car.move(random.getRandomNum()));
    }
}
