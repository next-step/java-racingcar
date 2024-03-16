package racingcar.controller;

import static racingcar.config.RacingCarConfig.numberGenerator;
import static racingcar.config.RacingCarConfig.racingView;
import static racingcar.config.RacingCarConfig.rule;

import racingcar.domain.MovementStrategy;
import racingcar.service.Race;
import racingcar.view.RacingView;
import racingcar.vo.GameResult;

public class RacingGame {

    public void play() {
        final RacingView racingView = racingView();
        final MovementStrategy carMovement = new MovementStrategy(rule(), numberGenerator());

        try {
            final String[] carNames = racingView.readCarNames();
            final int playingCount = racingView.readPlayingCount();

            final Race race = Race.of(carNames, carMovement);
            final GameResult gameResult = race.progress(playingCount);

            racingView.printGameResult(gameResult);

        } catch (final IllegalArgumentException e) {
            racingView.printBusinessExceptionMessage(e.getMessage());

        } catch (final Exception e) {
            racingView.printUnexpectedExceptionMessage();
        }
    }
}
