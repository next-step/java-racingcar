package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private static final int CAR_NAME_THRESHOLD = 5;

    private final List<Car> cars = new ArrayList<>();

    private Cars(List<String> carNames) {
        carNames.forEach(carName -> cars.add(Car.nameOf(carName)));
    }

    public static Cars namesOf(List<String> carNames) throws IllegalArgumentException {
        validateCarNames(carNames);
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

    private static void validateCarNames(List<String> carNames) throws IllegalArgumentException {
        if (carNames.stream().anyMatch(Cars::isOverThreshold)) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private static boolean isOverThreshold(String carName) {
        return carName.length() > CAR_NAME_THRESHOLD;
    }

    public void race(int movableThreshold) {
        cars.forEach(car -> car.moveForward(movableThreshold));
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
                .orElseThrow(() -> new NoSuchElementException("자동차가 존재하지 않습니다."));

        return cars.stream()
                .filter(car -> car.getPosition() == winnerScore)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
