package racing;

import racing.view.GameInput;
import racing.view.RacingGameInputView;
import racing.view.RacingResultView;

import java.util.List;

public class RacingGameRunner {

    public static void main(final String[] args) {
        final GameInput input = RacingGameInputView.record();
        final List<RacingCars> gameResult = RacingGame.createGame(input.getPlayerCount(), input.getTrialCount()).start();

        RacingResultView.print(gameResult);
    }
}
