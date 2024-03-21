package racingcar.controller;

import racingcar.config.RacingCarConfig;
import racingcar.domain.Rounds;
import racingcar.domain.cars.CarNames;
import racingcar.domain.cars.Cars;
import racingcar.domain.movement.MovementStrategy;
import racingcar.service.Race;
import racingcar.view.RacingView;
import racingcar.vo.GameResult;

public class RacingGame {

    private final RacingView racingView;

    public RacingGame(final RacingView racingView) {
        this.racingView = racingView;
    }

    public void run() {
        try {
            final GameResult gameResult = playGame();
            racingView.printGameResult(gameResult);

        } catch (final IllegalArgumentException e) {
            racingView.printBusinessExceptionMessage(e.getMessage());

        } catch (final Exception e) {
            racingView.printUnexpectedExceptionMessage();
        }
    }

    private GameResult playGame() {
        final CarNames carNames = CarNames.from(racingView.readCarNames());
        final Cars cars = Cars.from(carNames);

        final int playingCount = racingView.readPlayingCount();
        final Rounds rounds = Rounds.from(playingCount);

        final MovementStrategy movementStrategy = RacingCarConfig.movementStrategy();

        return new Race().progress(cars, rounds, movementStrategy);
    }
}
