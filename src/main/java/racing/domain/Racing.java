package racing.domain;

import utility.NumberHelper;

import java.util.*;
import java.util.stream.Collectors;

import static utility.NumberHelper.isLessThanOne;

/**
 * @author han
 */
public class Racing {
    private List<Car> cars;
    private int attempts;

    public Racing(List<String> users, int attempts) {
        throwIfHasInProperUsers(users);
        throwIfHasInProperAttempts(attempts);
        this.cars = createCars(users);
        this.attempts = attempts;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }

    public Winner play(Random random) {
        RacingHistory racingHistory = new RacingHistory();

        for (int i = 0; i < this.attempts; i++) {
            List<Car> group = movingCars(random);
            this.cars = group;
            racingHistory.add(group);
        }
        return Winner.from(this.cars, racingHistory);
    }

    private List<Car> createCars(List<String> users) {
        if (users == null || users.isEmpty()) {
            return Collections.emptyList();
        }

        return users.stream()
            .map(Car::create)
            .collect(Collectors.toList());
    }

    private List<Car> movingCars(Random random) {
        List<Car> group = new ArrayList<>();

        for (Car car : this.cars) {
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