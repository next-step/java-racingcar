package racingcar.view;

import racingcar.dto.output.RacingGameResponse;
import racingcar.dto.input.RacingCarRequest;
import racingcar.view.input.InputView;
import racingcar.view.output.ResultView;

public class RacingCarView {

    private RacingCarView() {
    }

    public static RacingCarRequest getInputValue() {
        String carNames = InputView.getCarNames();
        int racingCount = InputView.getRacingCount();
        return new RacingCarRequest(carNames, racingCount);
    }

    public static void printRacingResult(RacingGameResponse racingResult) {
        ResultView.printResult(racingResult);
    }
}
