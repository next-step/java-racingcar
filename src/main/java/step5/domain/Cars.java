package step5.domain;

import step5.domain.result.CarMovementResult;
import step5.domain.result.CarMovementRoundResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public static Cars from(List<String> carNames) {
        return new Cars(carNames);
    }

    private Cars(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            return;
        }

        this.cars.addAll(
                convertCarNamesToCarList(carNames));
    }

    private List<Car> convertCarNamesToCarList(List<String> carNames) {
        return carNames.stream()
                .map(Car::withName)
                .collect(Collectors.toList());
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }

    public CarMovementRoundResult moveAll(Moving movingStrategy) {
        return new CarMovementRoundResult(cars.stream()
                .map(car -> car.move(movingStrategy))
                .collect(Collectors.toList()));
    }

}
