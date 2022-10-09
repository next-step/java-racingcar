import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputTryNumber;
import static racingcar.view.OutputView.printResult;

import racingcar.Racing;
import racingcar.dto.RacingInput;
import racingcar.strategy.RandomNumberGenerateStrategy;

public class MainApplication {

    public static void main(String[] args) {
        RacingInput input = new RacingInput(inputCarNames(), inputTryNumber());

        Racing racing = new Racing(input.getCarNames());
        racing.race(input.getTryNumber());

        printResult(racing.getResult(), racing.winners());
    }
}
