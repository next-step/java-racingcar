package step4.domain;

import step4.domain.strategy.MovingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(MovingStrategy movingStrategy) {
        cars.stream()
                .forEach(car -> car.move(movingStrategy));
    }

    public String winnerCars() {
        int longDistance = cars.stream()
                .map(car -> car.getPosition())
                .max(Integer::compareTo).get();

        return cars.stream()
                .filter(car -> car.getPosition() == longDistance)
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
    }

    public List<Car> getCars() {
        return cars;
    }

}
