package racingcar.domain;

import racingcar.exception.ErrorMessage;
import racingcar.moving.MovingStrategy;
import racingcar.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String DELIMITER = ",";

    private List<Car> cars;

    public static Cars of(final String carNames) {
        validateCarNames(carNames);
        String[] splitCarNames = StringUtil.splitValues(carNames, DELIMITER);
        return new Cars(initCars(splitCarNames));
    }

    private Cars() {
    }

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    private static void validateCarNames(final String carNames) {
        if (StringUtil.isEmpty(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }
    }

    private static List<Car> initCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::of)
                .collect(Collectors.toList());
    }

    public void moveCars(final MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> getWinnerCars() {
        int winnerPosition = this.getWinnerPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(winnerPosition))
                .collect(Collectors.toList());
    }

    private int getWinnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(RuntimeException::new);
    }
}
