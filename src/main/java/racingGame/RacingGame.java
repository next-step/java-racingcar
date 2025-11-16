package racingGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    protected final List<Car> cars;
    private final int tryCount;
    private final MoveStrategy strategy;
    private final List<Round> rounds = new ArrayList<>();

    public RacingGame(int carCount, int tryCount, MoveStrategy strategy) {
        this.cars = initCars(carCount);
        this.tryCount = tryCount;
        this.strategy = strategy;
    }

    private List<Car> initCars(int count) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Car());
        }
        return list;
    }

    public List<Round> race() {
        for (int i = 0; i < tryCount; i++) {
            moveAllCars();
            saveRound();
        }
        return rounds;
    }

    protected void moveAllCars() {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    private void saveRound() {
        List<Integer> positions = new ArrayList<>();

        for (Car car : cars) {
            positions.add(car.position());
        }

        rounds.add(new Round(positions));
    }
}
