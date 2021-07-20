package racingGame;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static final int MIN_CAR_SIZE = 0;
    public static final int MIN_REPEAT_COUNT = 0;
    private final List<Car> cars = new ArrayList<>();
    private final int repeatCount;

    public Game(int carSize, int repeatCount) {
        valid(carSize, repeatCount);

        for (int i = 0; i < carSize; i++) {
            cars.add(new Car());
        }
        this.repeatCount = repeatCount;
    }

    public boolean run() {
        for (Car car : cars) {
            car.move(Tool.makeRandomNumber());
        }
        return true;
    }

    public boolean run(int[] numbers) {
        int index = 0;
        for (Car car : cars) {
            car.move(numbers[index++]);
        }
        return true;
    }

    public int getCarSize() {
        return cars.size();
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
