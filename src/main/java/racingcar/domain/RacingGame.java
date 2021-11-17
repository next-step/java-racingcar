package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final GameLog gameLog;

    private RacingGame(Cars cars) {
        this.cars = cars;
        this.gameLog = GameLog.init();
    }

    public static RacingGame of(Cars cars) {
        return new RacingGame(cars);
    }

    public GameLog play(Round round) {
        while (!round.isOver()) {
            round.counting();
            cars.move();

            recode(cars);
        }

        return gameLog;
    }

    private void recode(Cars cars) {
        List<Car> history = cars.getHistory().stream()
                .map(car -> car.from(car))
                .collect(Collectors.toList());

        gameLog.recode(RoundLog.from(history));
    }

}
