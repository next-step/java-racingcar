package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int tryCount;
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(int carCount, int tryCount) {
        validateCarCount(carCount);
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

    public int getCarCount() {
        return cars.size();
    }
}
