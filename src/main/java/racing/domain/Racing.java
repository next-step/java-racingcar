package racing.domain;

import utility.NumberHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static utility.NumberHelper.isLessThanOne;

/**
 * @author han
 */
public class Racing {
    private RacingCar racingCar;
    private int attempts;

    public Racing(List<String> users, int attempts) {
        throwIfHasInProperUsers(users);
        throwIfHasInProperAttempts(attempts);
        this.racingCar = RacingCar.createByUsers(users);
        this.attempts = attempts;
    }

    public Winner play(Random random) {
        RacingHistory racingHistory = RacingHistory.getInstance();

        for (int i = 0; i < this.attempts; i++) {
            List<Car> group = movingCars(random);
            this.racingCar = RacingCar.of(group);
            racingHistory.add(RacingCar.of(group));
        }
        return Winner.from(this.racingCar, racingHistory);
    }

    private List<Car> movingCars(Random random) {
        List<Car> group = new ArrayList<>();

        for (Car car : this.racingCar.getCars()) {
            int value = NumberHelper.getRandomValue(random, 10);
            group.add(car.getInstanceByForward(value));
        }
        return group;
    }

    private void throwIfHasInProperUsers(List<String> users) {
        if (users == null || isLessThanOne(users.size())) {
            throw new IllegalArgumentException();
        }
    }

    private void throwIfHasInProperAttempts(int attempts) {
        if (isLessThanOne(attempts)) {
            throw new IllegalArgumentException();
        }
    }
}