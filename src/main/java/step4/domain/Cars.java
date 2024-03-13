package step4.domain;

import step4.view.result.CarMovementResult;
import step4.view.result.CarMovementRoundResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public static Cars from(int carCount) {
        return new Cars(
                IntStream.range(0, carCount)
                        .mapToObj(idx -> new Car())
                        .collect(Collectors.toList())
        );
    }

    private Cars(List<Car> cars) {
        if (cars != null && !cars.isEmpty()) {
            this.cars.addAll(cars);
        }
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }

    public void moveAll(Moving movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    public CarMovementRoundResult roundResult() {
        return CarMovementRoundResult.from(movementResults());
    }

    private List<CarMovementResult> movementResults() {
        return cars.stream()
                .map(Car::movementResult)
                .collect(Collectors.toList());
    }
}
