package racingGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    protected final List<Car> cars;
    private final int tryCount;
    private final MoveStrategy strategy;
    private int playedCount = 0;
    public RacingGame(String carNames, int tryCount) {
        this(parseNames(carNames), tryCount, new RandomMoveStrategy());
    }

    public RacingGame(List<String> names, int tryCount, MoveStrategy strategy) {
        this.cars = initCars(names);
        this.tryCount = tryCount;
        this.strategy = strategy;
    }

    private static List<String> parseNames(String carNames) {
        return Stream.of(carNames.split(","))
            .map(String::trim)
            .filter(name -> !name.isEmpty())
            .collect(Collectors.toList());
    }

    private List<Car> initCars(List<String> names) {
        List<Car> list = new ArrayList<>();
        for (String name : names) {
            list.add(new Car(name));
        }
        return list;
    }
    public boolean isEnd() {
        return playedCount < tryCount;
    }

    public void race() {
        moveAllCars();
        playedCount++;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> findWinners() {
        int max = maxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSame(max)) {       // 메시지 기반 비교
                winners.add(car.name());
            }
        }
        return winners;
    }

    protected void moveAllCars() {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    private int maxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = car.max(max);          // 메시지 기반 max 갱신
        }
        return max;
    }
}
