package racingcar.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        assertDuplicateCarName(cars);
        this.cars = cars;
    }

    private static void assertDuplicateCarName(List<Car> cars) {
        Set<String> duplicatedName = new HashSet<>();
        for (Car car : cars) {
            validDuplicateCarName(duplicatedName, car);
            duplicatedName.add(car.getName());
        }
    }

    private static void validDuplicateCarName(Set<String> duplicatedName, Car car) {
        if (duplicatedName.contains(car.getName())) {
            throw new IllegalArgumentException("중복된 자동차 이름이 발견됐습니다.");
        }
    }

    public List<Car> getRoundResult() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> playOneRound() {
        moveCars();
        return Collections.unmodifiableList(cars);
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
            .filter(car -> car.isWinner(winnerPosition))
            .collect(Collectors.toList());
    }

}
