package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.util.Asserts;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        preAssert(cars);
        this.cars = cars;
    }

    private void preAssert(List<Car> cars) {
        assertEmptyCars(cars);
        assertDuplicateCarName(cars);
    }

    private void assertEmptyCars(List<Car> cars) {
        Asserts.isFalse(cars.isEmpty(), () -> "입력값 cars 리스트의 사이즈가 0 입니다.");
    }

    private void assertDuplicateCarName(List<Car> cars) {
        Set<String> duplicatedName = new HashSet<>();
        for (Car car : cars) {
            Asserts.isTrue(!duplicatedName.contains(car.getName()), () -> "중복된 자동차 이름이 발견됐습니다.");
            duplicatedName.add(car.getName());
        }
    }

    public List<Car> getRoundResult() {
        return List.copyOf(cars);
    }

    public void play() {
        moveCars();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        int winnerPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalStateException("Cars 배열이 비어있습니다."));

        return cars.stream()
            .filter(car -> isWinner(car.getPosition(), winnerPosition))
            .collect(Collectors.toList());
    }

    private boolean isWinner(int currentPosition, int winnerPosition) {
        return currentPosition == winnerPosition;
    }

}
