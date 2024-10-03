package racinggame.ui;

import racinggame.domain.RacingGameResult;

import java.util.List;

public class RacingGameViewFactory {
    public static RacingGameInputView createInputView() {
        return new RacingGameInputView(
            new RacingGameMessageReader(System.in),
            new RacingGameMessageWriter()
        );
    }

    public static RacingGameResultView createResultView(final List<RacingGameResult> racingCars) {
        return new RacingGameResultView(
            racingCars,
            new RacingGameMessageWriter()
        );
    }
}
