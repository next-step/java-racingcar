package racingcar.controller;

import static racingcar.RacingCarConfig.movingStrategy;
import static racingcar.RacingCarConfig.numberGenerator;
import static racingcar.RacingCarConfig.racingView;

import racingcar.domain.CarMovement;
import racingcar.domain.Race;
import racingcar.view.RacingView;
import racingcar.vo.GameResult;

public class RacingGame {

    public void play() {
        final RacingView racingView = racingView();
        final CarMovement carMovement = new CarMovement(movingStrategy(), numberGenerator());

        try {
            final String[] carNames = racingView.readCarNames();
            final int playingCount = racingView.readPlayingCount();

            final Race race = Race.of(carNames, playingCount, carMovement);
            final GameResult gameResult = race.progress();

            racingView.printGameResult(gameResult);

        } catch (final IllegalArgumentException e) {
            racingView.printBusinessExceptionMessage(e.getMessage());

        } catch (final Exception e) {
            racingView.printUnexpectedExceptionMessage();
        }
    }
}
