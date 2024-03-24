package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names, CarMoveStrategy carMoveStrategy) {
        cars = new ArrayList<>();
        for(String name : names) {
            cars.add(new Car(name, carMoveStrategy));
        }
    }

    public List<Car> move() {
        cars.forEach(Car::move);

        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isEqualPosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
