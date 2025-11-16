package racingGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    protected final List<Car> cars;
    private final int tryCount;
    private final MoveStrategy strategy;
    private final List<Round> rounds = new ArrayList<>();

    public RacingGame(List<String> names, int tryCount, MoveStrategy strategy) {
        this.cars = initCars(names);
        this.tryCount = tryCount;
        this.strategy = strategy;
    }

    private List<Car> initCars(List<String> names) {
        List<Car> list = new ArrayList<>();
        for (String name : names) {
            list.add(new Car(name.trim()));
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

    public List<String> winners() {
        int max = maxPosition();
        List<String> result = new ArrayList<>();

        for (Car car : cars) {
            if (car.position() == max) {
                result.add(car.name());
            }
        }
        return result;
    }

    private int maxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.position() > max) {
                max = car.position();
            }
        }
        return max;
    }
}
