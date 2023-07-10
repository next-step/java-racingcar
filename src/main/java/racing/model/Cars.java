package racing.model;

import racing.exception.IllegalCarNameException;
import racing.exception.IllegalPositionException;
import racing.exception.IllegalRandomNumberException;
import racing.model.generator.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MIN_MOVABLE = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateCarNames(carNames);
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalCarNameException();
        }
    }

    public List<CarVO> getCars() {
        return this.cars.stream()
                .map(CarVO::new)
                .collect(Collectors.toList());
    }

    public List<CarVO> nextRound(NumberGenerator numberGenerator) {
        for (Car car : this.cars) {
            goForwardIfMovable(car, numberGenerator);
        }
        return this.getCars();
    }

    private void goForwardIfMovable(Car car, NumberGenerator numberGenerator) {
        if (isMovable(numberGenerator.generate())) {
            car.goForward();
        }
    }

    private boolean isMovable(int value) {
        validateNumber(value);
        return MIN_MOVABLE <= value;
    }

    private void validateNumber(int value) {
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new IllegalRandomNumberException();
        }
    }

    public List<CarVO> getWinners() {
        int maxPosition = this.cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalPositionException::new);
        return this.cars.stream()
                .filter(car -> car.isPositionValue(maxPosition))
                .map(CarVO::new)
                .collect(Collectors.toList());
    }

}
