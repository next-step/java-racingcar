package step4.domain;

import step4.domain.judge.Judge;
import step4.domain.strategy.MovingStrategy;

import java.util.ArrayList;
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

    public String winnerCars(Judge judge) {
        int longDistance = (int) judge.judge(cars);
        return cars.stream()
                    .filter(car -> car.getPosition() == longDistance)
                    .map(car -> car.getName())
                    .collect(Collectors.joining(", "));
    }

    public List<Car> getCars() {
        return cars;
    }

}
