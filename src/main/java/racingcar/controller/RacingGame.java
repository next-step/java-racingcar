package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGame(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            outputView.printCarCountInputMessage();
            final int carCount = inputView.readIntNumber();

            outputView.printPlayingCountInputMessage();
            final int playingCount = inputView.readIntNumber();

            final Race race = Race.setUp(carCount, playingCount);

            race.run();

            outputView.printOneLine(race.result().toString());
        } catch (final Exception e) {
            outputView.printOneLine(e.getMessage());
        }
    }
}
