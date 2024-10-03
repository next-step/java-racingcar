package racinggame.ui;

import racinggame.domain.RacingGameResults;

public class RacingGameViewFactory {
    public static RacingGameInputView createInputView() {
        return new RacingGameInputView(
            new RacingGameMessageReader(System.in),
            new RacingGameMessageWriter()
        );
    }

    public static RacingGameResultView createResultView(final RacingGameResults racingGameResults) {
        return new RacingGameResultView(
            racingGameResults,
            new RacingGameMessageWriter()
        );
    }
}
