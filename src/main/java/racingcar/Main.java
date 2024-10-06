package racingcar;

import racingcar.dto.RacingResultDTO;
import racingcar.domain.RacingCarSimulator;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int tryNumber = InputView.inputTryNumber();

        RacingResultDTO result = RacingCarSimulator.simulate(carNames, tryNumber);
        ResultView.printRacingResult(result);
    }
}