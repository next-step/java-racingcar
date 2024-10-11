package racingcar;

import racingcar.domain.RacingCarSimulator;
import racingcar.dto.RacingResultDTO;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int tryNumber = InputView.inputTryNumber();

        RacingResultDTO result = RacingCarSimulator.simulate(carNames, tryNumber);
        ResultView.printRacingResult(result);
    }
}
