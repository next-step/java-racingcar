package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    private List<Car> cars;
    private int numberOfTurns;

    private Racing(List<Car> cars, int numberOfTurns) {
        this.cars = cars;
        this.numberOfTurns = numberOfTurns;
    }

    public static Racing withCondition(int numberOfCar, int numberOfTurns) {
        List<Car> cars = new ArrayList<>();
        while (numberOfCar > 0) {
            cars.add(new Car());
            numberOfCar--;
        }
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
