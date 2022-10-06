package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public List<Car> move(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
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
