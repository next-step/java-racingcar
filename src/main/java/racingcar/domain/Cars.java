package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    private static final String CAR_DOES_NOT_EXIST_EXCEPTION = "자동차가 존재하지 않습니다.";

    private Cars(List<String> carNames) {
        carNames.forEach(carName -> cars.add(Car.nameOf(carName)));
    }

    public static Cars namesOf(List<String> carNames) throws IllegalArgumentException {
        return new Cars(carNames);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cars)) return false;
        Cars cars1 = (Cars) o;
        return cars.equals(cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public void race() {
        cars.forEach(Car::moveForward);
    }

    public List<String> getCarNames() {
        return cars.stream().map(Car::getName).collect(Collectors.toList());
    }

    public List<Integer> getPositions() {
        return cars.stream().map(Car::getPosition).collect(Collectors.toList());
    }

    public List<String> getWinners() throws NoSuchElementException {
        int winnerScore = cars.stream()
                .map(Car::getPosition)
                .mapToInt(x -> x)
                .max()
                .orElseThrow(() -> new NoSuchElementException(CAR_DOES_NOT_EXIST_EXCEPTION));

        return cars.stream()
                .filter(car -> car.isSamePosition(winnerScore))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
