package racing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racing.NumberHelper.isLessThanOne;

/**
 * @author han
 */
public class Racing {
    private List<Car> cars;
    private int attempts;

    private Map<Integer, List<Car>> logs = new HashMap<>();

    public Racing(int cars, int attempts) {
        if (isLessThanOne(cars) || isLessThanOne(attempts)) {
            throw new IllegalArgumentException();
        }

        this.cars = createCars(cars);
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
            List<Car> temp = new ArrayList<>();
            for (Car car : this.cars) {
                int value = NumberHelper.getRandomValue(random, 10);
                temp.add(car.getInstanceByForward(value));
            }
            this.cars = temp;
            this.logs.put(i, temp);
        }
    }

    private List<Car> createCars(int count) {
        return IntStream.range(0, count).mapToObj(i -> Car.create()).collect(Collectors.toList());
    }
}