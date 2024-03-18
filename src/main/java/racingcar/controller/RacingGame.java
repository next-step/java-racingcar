package racingcar.controller;

import racingcar.domain.CarNames;
import racingcar.domain.MovementStrategy;
import racingcar.service.Race;
import racingcar.view.RacingView;
import racingcar.vo.GameResult;

public class RacingGame {

    private final RacingView racingView;
    private final MovementStrategy movementStrategy;

    public RacingGame(final RacingView racingView, final MovementStrategy movementStrategy) {
        this.racingView = racingView;
        this.movementStrategy = movementStrategy;
    }

    public void play() {
        try {
            final CarNames carNames = CarNames.from(racingView.readCarNames());
            final int playingCount = racingView.readPlayingCount();

            final Race race = Race.of(carNames, movementStrategy);
            final GameResult gameResult = race.progress(playingCount);

            racingView.printGameResult(gameResult);

        } catch (final IllegalArgumentException e) {
            racingView.printBusinessExceptionMessage(e.getMessage());

        } catch (final Exception e) {
            racingView.printUnexpectedExceptionMessage();
        }
    }
}
