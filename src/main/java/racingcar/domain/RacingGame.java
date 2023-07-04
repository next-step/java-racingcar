package racingcar.domain;

import java.util.HashSet;
import java.util.Set;
import racingcar.util.Asserts;

public class RacingGame {
    private final Car[] cars;

    public RacingGame(Car... cars) {
        assertDuplicateCarName(cars);
        this.cars = cars;
    }

    private static void assertDuplicateCarName(Car... cars) {
        Set<String> duplicatedName = new HashSet<>();
        for (Car car : cars) {
            Asserts.isTrue(!duplicatedName.contains(car.getName()), () -> "중복된 자동차 이름이 발견됐습니다.");
            duplicatedName.add(car.getName());
        }
    }

    public Car[] getRoundResult() {
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

    public Car[] getWinners() {
        return null;
    }
}
