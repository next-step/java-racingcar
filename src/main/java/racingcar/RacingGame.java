package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int tryCount;
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(int carCount, int tryCount) {
        validateCarCount(carCount);
        validateTryCount(tryCount);
        this.tryCount = tryCount;
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private static void validateCarCount(int carCount) {
        if (carCount < 1) {
            throw new RuntimeException("자동차 대수는 1 이상이어야 합니다.");
        }
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount < 0) {
            throw new RuntimeException("시도 횟수는 0 이상이어야 합니다.");
        }
    }

    public int getCarCount() {
        return cars.size();
    }

    public int getTryCount() {
        return tryCount;
    }
}
