package racing;

import java.util.*;
import java.util.stream.Collectors;

import static racing.NumberHelper.isLessThanOne;

/**
 * @author han
 */
public class Racing {
    private List<Car> cars;
    private int attempts;

    private Map<Integer, List<Car>> logs = new HashMap<>();

    public Racing(List<String> users, int attempts) {
        if (users == null || isLessThanOne(users.size()) || isLessThanOne(attempts)) {
            throw new IllegalArgumentException();
        }

        this.cars = createCars(users);
        this.attempts = attempts;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }

    public Map<Integer, List<Car>> getLogs() {
        return logs;
    }

    public void play(Random random) {
        for (int i = 0; i < this.attempts; i++) {
            List<Car> group = movingCars(random);
            this.cars = group;
            this.logs.put(i, group);
        }
    }

    private List<Car> createCars(List<String> users) {
        if (users == null || users.isEmpty()) {
            return Collections.emptyList();
        }

        return users.stream()
            .map(user -> Car.create(user))
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
}