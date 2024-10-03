package racinggame.domain;

import racinggame.ui.RacingGameInputView;
import racinggame.ui.RacingGameResultView;
import racinggame.ui.RacingGameViewFactory;

import java.util.List;

public class RacingRunner {
    public void start() {
        final RacingGame racingGame = settingRacingGame();
        final List<RacingGameResult> results = racingGame.play();
        final RacingGameResultView racingGameResultView = RacingGameViewFactory.createResultView(results);
        racingGameResultView.display();
    }

    private RacingGame settingRacingGame() {
        final RacingGameInputView racingGameInputView = RacingGameViewFactory.createInputView();
        final RacingCars racingCars = racingGameInputView.inputRacingCarNames();
        final int roundCount = racingGameInputView.inputRacingRoundCount();
        return new RacingGame(racingCars, roundCount);
    }
}
