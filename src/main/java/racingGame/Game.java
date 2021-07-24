package racingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Game {

    public static final int MIN_CAR_COUNT = 0;
    public static final int MIN_REPEAT_COUNT = 0;

    private final int repeatCount;
    private List<Car> cars = new ArrayList<>();

    public Game(List<String> names, int repeatCount) {
        validCarCount(names.size());
        validRepeatCount(repeatCount);

        for (String name : names) {
            cars.add(new Car(name));
        }
        this.repeatCount = repeatCount;
    }

    public boolean runOnce(List<Integer> numbers) {
        AtomicInteger index = new AtomicInteger();
        cars = cars.stream()
                .map(car -> car.move(numbers.get(index.getAndIncrement())))
                .collect(Collectors.toList());
        return true;
    }

    public List<Integer> getCarsStatus() {
        return cars.stream()
                .map(Car::getDistance)
                .collect(Collectors.toList());
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    private void validCarCount(int carCount) {
        if (carCount <= MIN_CAR_COUNT) {
            throw new IllegalArgumentException("자동차 수는 0 혹은 음수가 될 수 없습니다.");
        }
    }

    private void validRepeatCount(int repeatCount) {
        if (repeatCount <= MIN_REPEAT_COUNT) {
            throw new IllegalArgumentException("반복 횟수는 0 혹은 음수가 될 수 없습니다.");
        }
    }
}
