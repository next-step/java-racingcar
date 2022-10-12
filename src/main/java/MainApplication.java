import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputTryNumber;
import static racingcar.view.OutputView.printResult;

import racingcar.domain.Racing;
import racingcar.domain.CarNames;
import racingcar.domain.TryNumber;

public class MainApplication {

    public static void main(String[] args) {
        CarNames carNamesInput = new CarNames(inputCarNames());
        TryNumber tryNumberInput = new TryNumber(inputTryNumber());

        Racing racing = new Racing(carNamesInput.getCarNames());
        racing.race(tryNumberInput.getTryNumber());

        printResult(racing.getResult(), racing.winners());
    }
}
