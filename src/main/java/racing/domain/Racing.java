package racing.domain;

import racing.view.Winner;
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
        checkHasProperValues(users, attempts);
        this.cars = createCars(users);
        this.attempts = attempts;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }

    public void play(Random random, Winner winner) {
        for (int i = 0; i < this.attempts; i++) {
            List<Car> group = movingCars(random);
            this.cars = group;
            winner.addHistory(i, group);
        }
        winner.addWinner(getWinners());
    }

    public List<Car> getWinners() {
        int max = getMaxStep();

        return this.cars.stream()
            .filter(c -> c.hasEqualTo(max))
            .collect(Collectors.toList());
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

    private int getMaxStep() {
        return this.cars.stream()
            .mapToInt(Car::getStep)
            .max()
            .orElseThrow(NoSuchElementException::new);
    }

    private void checkHasProperValues(List<String> users, int attempts) {
        if (users == null || isLessThanOne(users.size()) || isLessThanOne(attempts)) {
            throw new IllegalArgumentException();
        }
    }
}