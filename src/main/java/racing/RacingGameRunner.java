package racing;

import view.RacingInput;
import view.RacingInputView;
import view.RacingResultView;

import java.util.List;

public class RacingGameRunner {
    public static void main(String[] args) {
        final RacingInput input = RacingInputView.getInputFromUser();
        final RacingGame racingGame = RacingGame.init(input.getCarNames(), input.getTrialCount());
        final List<RacingCars> result = racingGame.start();
        final RacingGamePrize racingGamePrize = RacingGamePrize.init(result);
        final RacingCars winners = racingGamePrize.getWinners();

        RacingResultView.printResult(result, winners);
    }
}
