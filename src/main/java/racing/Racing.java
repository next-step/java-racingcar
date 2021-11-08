package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author han
 */
public class Racing {
    private List<Car> cars;
    private int attempts;

    public Racing(Integer cars, Integer attempts) {
        if (cars == null || cars.intValue() < 1) {
            throw new IllegalArgumentException();
        }

        if (attempts == null || attempts.intValue() < 1) {
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

    public void play() {
        for (int i = 0; i < this.attempts; i++) {
            for (Car car : this.cars) {
                int random = NumberHelper.getRandomValue(10);
                car.forward(random);
            }
        }
    }

    private List<Car> createCars(int count) {
        return IntStream.range(0, count).mapToObj(i -> new Car()).collect(Collectors.toList());
    }
}