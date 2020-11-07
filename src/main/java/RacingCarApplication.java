import racingcar.domain.RandomStrategyGenerator;
import racingcar.domain.Racing;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) throws Exception {
        List<String> carNames = InputView.askToInsertCarNames();
        int numberOfTries = InputView.askToInsertNumberOfTries();

        Racing racing = new Racing(carNames, numberOfTries);
        racing.setStrategyGenerator(new RandomStrategyGenerator());
        String result = racing.race();

        ResultView.print(result);
    }
}
