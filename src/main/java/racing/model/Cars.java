package racing.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getWinnersName() {
        return cars.stream()
                .filter(car -> car.isWinner(getMaxPosition()))
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
