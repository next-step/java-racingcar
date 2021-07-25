package racingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Game {

    public static final String VALID_CAR_COUNT_MESSAGE = "자동차 수는 0 혹은 음수가 될 수 없습니다.";
    public static final String VALID_REPEAT_COUNT_MESSAGE = "반복 횟수는 0 혹은 음수가 될 수 없습니다.";
    public static final int MIN_CAR_COUNT = 0;
    public static final int MIN_REPEAT_COUNT = 0;

    private final int repeatCount;
    private List<Car> cars = new ArrayList<>();

    public Game(List<Car> cars, int repeatCount) {
        validCarCount(cars.size());
        validRepeatCount(repeatCount);

        this.cars.addAll(cars);
        this.repeatCount = repeatCount;
    }

    public boolean runOnce(List<Integer> numbers) {
        AtomicInteger index = new AtomicInteger();
        cars = cars.stream()
                .map(car -> car.move(numbers.get(index.getAndIncrement())))
                .collect(Collectors.toList());
        return true;
    }

    public List<Car> findWinners() {
        int maxDistance = getMaxCarDistance();
        return cars.stream()
                .filter(car -> car.equalsDistance(maxDistance))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    private int getMaxCarDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max().orElse(0);
    }

    private void validCarCount(int carCount) {
        if (carCount <= MIN_CAR_COUNT) {
            throw new IllegalArgumentException(VALID_CAR_COUNT_MESSAGE);
        }
    }

    private void validRepeatCount(int repeatCount) {
        if (repeatCount <= MIN_REPEAT_COUNT) {
            throw new IllegalArgumentException(VALID_REPEAT_COUNT_MESSAGE);
        }
    }
}