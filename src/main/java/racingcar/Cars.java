package racingcar;

import io.PrintView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names, CarMoveStrategy[] carMoveStrategies) {
        cars = new ArrayList<>();
        for(String name : names) {
            cars.add(new Car(name, carMoveStrategies));
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public void printPosition() {
        cars.forEach(PrintView::printPosition);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.hasEqualPosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
