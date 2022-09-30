package racingcar.domain;

import racingcar.util.RandomNumber;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> playRace() {
        for (Car car : cars) {
            car.move(RandomNumber.makeRandomNumber());
        }
        return cars;
    }

    public List<Car> findWinners() {
        return getPositionEntrySet(cars)
                .stream().max(Comparator.comparing(Map.Entry::getKey))
                .get()
                .getValue();
    }

    private Set<Map.Entry<Integer, List<Car>>> getPositionEntrySet(List<Car> cars) {
        return cars.stream().collect(groupingBy(Car::getPosition)).entrySet();
    }


}
