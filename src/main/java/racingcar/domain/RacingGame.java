package racingcar.domain;

import java.util.List;
import racingcar.domain.dto.GameResult;
import racingcar.domain.dto.RoundResult;

public class RacingGame {

    private final Cars cars;
    private final DrivingStrategy drivingStrategy;
    private final GameResult gameResult = new GameResult();

    public RacingGame(List<String> carNames, DrivingStrategy drivingStrategy) {
        this.cars = Cars.from(carNames);
        this.drivingStrategy = drivingStrategy;
    }

    public void play(int roundAmount) {
        Round round = Round.of(roundAmount);
        while (!round.isEnd()) {
            round.progress();
            play();
        }
    }

    private void play() {
        cars.drive(drivingStrategy);
        RoundResult roundResult = cars.result();
        gameResult.report(roundResult);
    }

    public GameResult result() {
        return gameResult;
    }

    public Winners winners() {
        return cars.winners();
    }
}
