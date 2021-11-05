package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final int MIN_CREATE_COUNT = 1;

    private final List<Car> cars;

    public Cars(int count) {
        validateCreateCount(count);

        this.cars = Stream.generate(Car::from)
                .limit(count)
                .collect(Collectors.toList());
    }

    private void validateCreateCount(int count) {
        if (count < MIN_CREATE_COUNT) {
            throw new CreateCarCountException(count);
        }
    }

    public void move(TryCount tryCount, MovingStrategy strategy) {
        while (tryCount.isDone()) {
            tryCount.counting();
            cars.forEach(car -> car.move(strategy));
        }
    }

    public int size() {
        return cars.size();
    }
}
