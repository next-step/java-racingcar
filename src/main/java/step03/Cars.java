package step03;

import step03.strategy.MoveStrategy;
import step03.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    public List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of (List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars of (int numberOfCars) {
        return of(Stream.iterate(0, n -> n + 1)
                        .limit(numberOfCars)
                        .map(n -> Car.of())
                        .collect(Collectors.toList()));
    }

    public void move(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public void show() {
        ResultView.print(cars);
    }
}
