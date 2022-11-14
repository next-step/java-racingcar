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

    public String findWinners() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(DEFAULT_VALUE);

        return cars.stream()
            .filter(car -> car.isMaxPosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.joining(DELIMITER_FOR_WINNER));
    }

    public List<Integer> getPosition() {
        return cars.stream().map(Car::getPosition).collect(Collectors.toList());
    }

    public String[] getNames() {
        String[] names = new String[cars.size()];
        int carNumber = 0;
        for (Car car : cars) {
            names[carNumber] = car.getName();
            carNumber++;
        }
        return names;
    }
}
