package racingcar.domain;

import racingcar.util.Asserts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        assertDuplicateCarName(cars);
        this.cars = cars;
    }

    private static void assertDuplicateCarName(List<Car> cars) {
        Set<String> duplicatedName = new HashSet<>();
        for (Car car : cars) {
            Asserts.isTrue(!duplicatedName.contains(car.getName()), () -> "중복된 자동차 이름이 발견됐습니다.");
            duplicatedName.add(car.getName());
        }
    }

    public List<Car> getRoundResult() {
        return cars;
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
                .orElseThrow(() -> new IllegalArgumentException("우승한 자동차가 나오지 않은 상황이 발생했습니다."));

        return cars.stream()
            .filter(car -> isWinner(car.getPosition(), winnerPosition))
            .collect(Collectors.toList());
    }

    private boolean isWinner(int currentPosition, int winnerPosition) {
        return currentPosition == winnerPosition;
    }

}
