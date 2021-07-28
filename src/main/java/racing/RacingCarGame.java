package racing;

import racing.model.RandomNumberComparison;
import racing.model.RacingCars;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingCarGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.printRacingCarNamesInputMessage();
        RacingCars racingCars = new RacingCars(inputView.inputRacingCarNames());
        inputView.printMovementTrialCountInputMessage();
        int movementTrialCount = inputView.inputMovementTrialCount();

        ResultView resultView = new ResultView();
        resultView.printRacingCarGameResultOutputMessage();

        for (int trialOrder = 0; trialOrder < movementTrialCount; trialOrder++) {
            racingCars.moveForwardOneStepOrStop(new RandomNumberComparison());
            resultView.printRacingCarsStatus(racingCars.getRacingCars());
        }
        resultView.printRacingWinners(racingCars.getWinners());
    }
}
