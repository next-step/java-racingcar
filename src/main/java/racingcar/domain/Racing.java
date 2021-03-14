package racingcar.domain;

import racingcar.util.RandomUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private List<Car> cars;
    private int numberOfTurns;

    private Racing(List<Car> cars, int numberOfTurns) {
        this.cars = cars;
        this.numberOfTurns = numberOfTurns;
    }

    public static Racing withCondition(String[] namesOfCars, int numberOfTurns) {
        List<Car> cars = Arrays.stream(namesOfCars)
                .map(Car::new)
                .collect(Collectors.toList());

        return new Racing(cars, numberOfTurns);
    }

    public void race() {
        if (hasRaceEnd()) {
            throw new IllegalStateException("레이싱이 종료되었습니다.");
        }
        cars.forEach(car -> car.moveOrStay(RandomUtil.getRandomIntBetweenZeroToNine()));
        reduceTurns();
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
