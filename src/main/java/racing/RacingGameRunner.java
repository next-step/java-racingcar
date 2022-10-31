package racing;

import view.RacingInput;
import view.RacingInputView;
import view.RacingResultView;

public class RacingGameRunner {
    public static void main(String[] args) {
        final RacingInput input = RacingInputView.getInputFromUser();
        final RacingGame racingGame = RacingGame.init(input.getCarNames(), input.getTrialCount());
        final RacingGamePrize racingGamePrize = racingGame.start();
        final RacingRecordCars winners = racingGamePrize.getWinners();

        RacingResultView.printResult(racingGamePrize, winners);
    }
}
