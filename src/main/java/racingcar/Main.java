package racingcar;

import racingcar.dto.RacingResultDTO;
import racingcar.logic.RacingCarSimulator;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;


public class Main {
    public static void main(String[] args) {
        int carNumber = InputView.inputCarNumber();
        int tryNumber = InputView.inputTryNumber();

        RacingResultDTO result = RacingCarSimulator.simulate(carNumber, tryNumber);
        ResultView.printRacingResult(result);
    }
}