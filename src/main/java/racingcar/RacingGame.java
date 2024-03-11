package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private static final String CAR_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String PLAYING_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGame(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            outputView.printOneLine(CAR_COUNT_INPUT_MESSAGE);
            final int carCount = inputView.readIntNumber();

            outputView.printOneLine(PLAYING_COUNT_INPUT_MESSAGE);
            final int playingCount = inputView.readIntNumber();

            final Race race = Race.setUp(carCount, playingCount);

            race.run();

            outputView.printOneLine(race.result().toString());
        } catch (final Exception e) {
            outputView.printOneLine(e.getMessage());
        }
    }
}
