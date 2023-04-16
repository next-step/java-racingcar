package racingcar.main;

import racingcar.ui.InputView;
import racingcar.RacingCar;
import racingcar.RandomNumber;
import racingcar.ui.ResultView;

import java.util.List;

public class Main {

    public static final int BEGIN_INDEX = 0;

    public static void main(String[] args) {
        ResultView resultView = createResultView();
        InputView inputView = createInputView();

        resultView.printQuestionCarCountMessage();
        int carCount = inputView.getIntegerInput();

        resultView.printQuestionTryCountMessage();
        int tryCount = inputView.getIntegerInput();

        resultView.printNewLine();
        resultView.printExecuteResultMessage();

        RacingCar racingCar = createRacingCar(carCount);

        for (int i = BEGIN_INDEX; i < tryCount; i++) {
            resultView.printMoveStateLines(
                    racingCar.makeMoveCounts(generateRandomNumbers(carCount))
            );
        }

        inputView.closeScanner();
    }

    private static ResultView createResultView() {
        return new ResultView();
    }

    private static InputView createInputView() {
        return new InputView();
    }

    private static RacingCar createRacingCar(int carCount) {
        return new RacingCar(carCount);
    }

    private static List<Integer> generateRandomNumbers(int carCount) {
        return new RandomNumber().generateNumbers(carCount);
    }
}