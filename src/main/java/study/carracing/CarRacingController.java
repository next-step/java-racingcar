package study.carracing;

import study.carracing.domain.Racing;
import study.carracing.ui.InputView;
import study.carracing.ui.ResultView;
import study.carracing.util.Validator;

public class CarRacingController {

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        Validator.validateInput(carCount);
        int tryCount = InputView.inputTryCount();
        Validator.validateInput(tryCount);

        Racing racing = new Racing(carCount);
        racing.start(tryCount);

        ResultView.outputResult(racing.getRacingCars().getCars());
    }
}
