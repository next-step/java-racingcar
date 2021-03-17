package racingcar.domain;

import racingcar.util.RandomUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private int numberOfTurns;

    private RacingGame(List<Car> cars, int numberOfTurns) {
        this.cars = cars;
        this.numberOfTurns = numberOfTurns;
    }

    public static RacingGame withCondition(String[] namesOfCars, int numberOfTurns) {
        List<Car> cars = Arrays.stream(namesOfCars)
                .map(Car::new)
                .collect(Collectors.toList());

        return new RacingGame(cars, numberOfTurns);
    }

    public void race() {
        if (hasRaceEnd()) {
            throw new IllegalStateException("레이싱이 종료되었습니다.");
        }
        cars.forEach(car -> car.moveOrStay(RandomUtil.getRandomIntBetweenZeroToNine()));
        reduceTurns();
    }

    public List<Car> getWinners() {
        if (!hasRaceEnd()) {
            throw new IllegalStateException("레이싱이 종료되지 않았습니다.");
        }

        final int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("포지션은 null 일 수 없습니다."));

        return cars.stream()
                .filter(car -> car.equalsPosition(maxPosition))
                .collect(Collectors.toList());
    }

    public boolean hasRaceEnd() {
        return numberOfTurns == 0;
    }

    private void reduceTurns() {
        numberOfTurns--;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }
}
