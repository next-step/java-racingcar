package racingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Game {

    public static final int MIN_CAR_SIZE = 0;
    public static final int MIN_REPEAT_COUNT = 0;

    private final int repeatCount;
    private List<Car> cars = new ArrayList<>();

    public Game(int carSize, int repeatCount) {
        valid(carSize, repeatCount);

        for (int i = 0; i < carSize; i++) {
            cars.add(new Car());
        }
        this.repeatCount = repeatCount;
    }

    public void runOnce() {
        cars = cars.stream()
                .map(car -> car.move(Tool.makeRandomNumber()))
                .collect(Collectors.toList());
    }

    public boolean runOnce(int[] numbers) {
        AtomicInteger index = new AtomicInteger();
        cars = cars.stream()
                .map(car -> car.move(numbers[index.getAndIncrement()]))
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

    private void valid(int carSize, int repeatCount) {
        validCarSize(carSize);
        validRepeatCount(repeatCount);
    }

    private void validCarSize(int carSize) {
        if (carSize <= MIN_CAR_SIZE)
            throw new IllegalArgumentException("자동차 수는 0 혹은 음수가 될 수 없습니다.");
    }

    private void validRepeatCount(int repeatCount) {
        if (repeatCount <= MIN_REPEAT_COUNT)
            throw new IllegalArgumentException("반복 횟수는 0 혹은 음수가 될 수 없습니다.");
    }
}
