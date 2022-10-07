import static racingcar.view.InputView.inputCarNumber;
import static racingcar.view.InputView.inputTryNumber;
import static racingcar.view.OutputView.printResult;

import racingcar.Cars;
import racingcar.Racing;

public class MainApplication {

    public static void main(String[] args) {
        int carNumber = inputCarNumber();
        int tryNumber = inputTryNumber();

        Racing racing = new Racing(carNumber);
        racing.race(tryNumber);

        printResult(racing.result());
    }
}
