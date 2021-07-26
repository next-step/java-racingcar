package racing;

import racing.model.RacingCars;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingCarGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.printRacingCarCountInputMessage();
        int racingCarCount = inputView.inputRacingCarCount();

        inputView.printMovementTrialCountInputMessage();
        int movementTrialCount = inputView.inputMovementTrialCount();

        RacingCars racingCars = new RacingCars(racingCarCount);

        ResultView resultView = new ResultView();
        resultView.printRacingCarGameResultOutputMessage();

        for (int trialOrder = 0; trialOrder < movementTrialCount; trialOrder++) {
            racingCars.moveOrStop();
            resultView.printRacingCarsPosition(racingCars.getRacingCarPositions());
        }
    }
}
