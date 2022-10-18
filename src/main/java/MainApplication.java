import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputTryNumber;
import static racingcar.view.OutputView.printResult;

import java.util.List;
import racingcar.domain.Racing;

public class MainApplication {

    public static void main(String[] args) {
        List<String> carNames = inputCarNames();
        int tryNumber = inputTryNumber();

        Racing racing = new Racing(carNames);
        racing.race(tryNumber);

        printResult(racing.getResult(), racing.winners());
    }
}
