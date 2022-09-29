package racingcar;

import racingcar.util.RandomNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Race {
    private final List<Car> cars = new ArrayList<>();

    public Race(String[] carNames) {
        ready(carNames);
    }

    private void ready(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    public List<Car> playRace() {
        for (Car car : cars) {
            car.move(RandomNumber.makeRandomNumber());
        }
        return cars;
    }

    public List<Car> findWinners(List<Car> cars) {
        return cars.stream().collect(groupingBy(Car::getPosition)).entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .get()
                .getValue();
    }
}
