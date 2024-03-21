package racingcar.controller;

import racingcar.config.RacingCarConfig;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.MovementStrategy;
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
            play();
        } catch (final IllegalArgumentException e) {
            racingView.printBusinessExceptionMessage(e.getMessage());
        } catch (final Exception e) {
            racingView.printUnexpectedExceptionMessage();
        }
    }

    private void play() {
        final CarNames carNames = CarNames.from(racingView.readCarNames());
        final Cars cars = Cars.from(carNames);
        final int playingCount = racingView.readPlayingCount();

        final Race race = new Race();
        final MovementStrategy movementStrategy = RacingCarConfig.movementStrategy();
        final GameResult gameResult = race.progress(cars, playingCount, movementStrategy);

        racingView.printGameResult(gameResult);
    }
}
