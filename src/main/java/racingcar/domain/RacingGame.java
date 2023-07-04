package racingcar.domain;

import java.util.HashSet;
import java.util.Set;

public class RacingGame {

    private final Car[] cars;

    public RacingGame(Car... cars) {
        assertDuplicateCarName(cars);
        this.cars = cars;
    }

    private static void assertDuplicateCarName(Car... cars) {
        Set<String> duplicatedName = new HashSet<>();
        for (Car car : cars) {
            throwIfDuplicatedCarName(duplicatedName, car);
            duplicatedName.add(car.getName());
        }
    }

    private static void throwIfDuplicatedCarName(Set<String> duplicatedName, Car car) {
        if (duplicatedName.contains(car.getName())) {
            throw new IllegalArgumentException("중복된 자동차 이름이 발견됐습니다.");
        }
    }

}
