package race.domian;

import race.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int DEFAULT_VALUE = 0;

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void move(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

   public List<String> findWinners() {
       return cars.stream()
            .filter(car -> car.isWinner(getMaxPosition()))
            .map(Car::getName)
            .collect(Collectors.toList());
    }
    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_VALUE);
    }

    public List<Integer> getPosition() {
        return cars.stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
