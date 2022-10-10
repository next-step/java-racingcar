import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputTryNumber;
import static racingcar.view.OutputView.printResult;

import racingcar.Racing;
import racingcar.input.CarNamesInput;
import racingcar.input.TryNumberInput;

public class MainApplication {

    public static void main(String[] args) {
        CarNamesInput carNamesInput = new CarNamesInput(inputCarNames());
        TryNumberInput tryNumberInput = new TryNumberInput(inputTryNumber());

        Racing racing = new Racing(carNamesInput.getCarNames());
        racing.race(tryNumberInput.getTryNumber());

        printResult(racing.getResult(), racing.winners());
    }
}
