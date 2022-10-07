import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputTryNumber;
import static racingcar.view.OutputView.printResult;

import java.util.List;
import racingcar.Racing;
import racingcar.strategy.RandomNumberGenerateStrategy;

public class MainApplication {

    public static void main(String[] args) {
        List<String> carNames = inputCarNames();
        int tryNumber = inputTryNumber();

        Racing racing = new Racing(carNames, new RandomNumberGenerateStrategy(10));
        racing.race(tryNumber);

        printResult(racing.result(), racing.winners());
    }
}
