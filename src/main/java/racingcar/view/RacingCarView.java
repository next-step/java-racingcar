package racingcar.view;

import racingcar.domain.car.Cars;
import racingcar.view.input.RacingCarParameter;
import racingcar.view.input.InputView;
import racingcar.view.output.ResultView;

import java.util.List;

public class RacingCarView {

    private RacingCarView() {
    }

    public static RacingCarParameter getInputValue() {
        String carNames = InputView.getCarNames();
        int racingCount = InputView.getRacingCount();
        return new RacingCarParameter(carNames, racingCount);
    }

    public static void printRacingResult(List<Cars> racingResult) {
        ResultView.printResult(racingResult);
    }
}
