package racingcar.controller;

import racingcar.domain.Race;
import racingcar.vo.GameResult;

public class RacingGame {

    private final RacingScreen racingScreen;

    public RacingGame(final RacingScreen racingScreen) {
        this.racingScreen = racingScreen;
    }

    public void play() {
        try {
            final String[] carNames = racingScreen.readCarNames();
            final int playingCount = racingScreen.readPlayingCount();

            final Race race = new Race(carNames, playingCount);
            final GameResult gameResult = race.progress();

            racingScreen.printGameResult(gameResult);
        } catch (final IllegalArgumentException e) {
            racingScreen.printBusinessExceptionMessage(e.getMessage());
        } catch (final Exception e) {
            racingScreen.printUnexpectedExceptionMessage();
        }
    }
}
