package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int tryCount;
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(int carCount, int tryCount) {
        this.tryCount = tryCount;
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public int getCarCount() {
        return cars.size();
    }
}
