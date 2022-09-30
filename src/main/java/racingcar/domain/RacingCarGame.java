package racingcar.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarGame {

    private final Cars cars;
    private final int times;
    private final GameHistory gameHistory = new GameHistory();

    public RacingCarGame(int carNum, int times) {
        this.cars = createCars(carNum);
        this.times = times;
    }

    private Cars createCars(int carNum) {
        return new Cars(Stream.generate(Car::new)
                .limit(carNum).collect(Collectors.toList()));
    }

    public GameHistory start() {
        for (int round = 0; round < times; round++) {
            gameHistory.addResult(cars.play());
        }
        return gameHistory;
    }
}
