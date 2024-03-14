package racingcar.controller;

import racingcar.domain.Race;
import racingcar.util.NumberGenerator;
import racingcar.vo.GameResult;

public class RacingGame {

    private final RacingScreen racingScreen;
    private final NumberGenerator numberGenerator;

    public RacingGame(final RacingScreen racingScreen, final NumberGenerator numberGenerator) {
        this.racingScreen = racingScreen;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        try {
            final int carCount = racingScreen.readCarCount();
            final int playingCount = racingScreen.readPlayingCount();
            final Race race = new Race(carCount, playingCount);

            race.run();

            final GameResult gameResult = race.result();
            racingScreen.printGameResult(gameResult);
        } catch (final IllegalArgumentException e) {
            racingScreen.printBusinessExceptionMessage(e.getMessage());
        } catch (final Exception e) {
            racingScreen.printUnexpectedExceptionMessage();
        }
    }
}
