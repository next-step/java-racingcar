package racinggame;

import racinggame.utils.MoveValueGenerator;
import racinggame.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void advance() {
        cars.forEach(car -> car.advance(MoveValueGenerator.generateMoveValue()));
    }


    public ResultView advanceStatus() {
        return new ResultView(
                cars.stream()
                .map(Car::advanceStatus)
                .collect(Collectors.toList()));
    }

    public int numberOfCars() {
        return cars.size();
    }
}
