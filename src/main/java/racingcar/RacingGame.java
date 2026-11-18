package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private final int turnCount;

    public RacingGame(int carCount, int turnCount) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
        this.turnCount = turnCount;
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
