package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class Main {

    public static final int BEGIN_INDEX = 0;

    public static void main(String[] args) {
        ResultView resultView = createResultView();
        InputView inputView = createInputView();

        resultView.printInputCarNameMessage();
        String carNameInput = inputView.getStringInput();

        resultView.printQuestionTryCountMessage();
        int tryCount = inputView.getIntegerInput();

        resultView.printNewLine();
        resultView.printExecuteResultMessage();

        RacingCar racingCar = createWinningRacingCar(carNameInput);

        for (int i = BEGIN_INDEX; i < tryCount; i++) {
            resultView.printCarNameAndMoveStateLines(
                    racingCar.makeMoveCounts(
                            generateRandomNumbers(racingCar.carsSize()))
            );
        }
        resultView.printWinners(racingCar.winningCars());

        inputView.closeScanner();
    }

    private static ResultView createResultView() {
        return new ResultView();
    }

    private static InputView createInputView() {
        return new InputView();
    }

    private static RacingCar createWinningRacingCar(String carNameInput) {
        return new RacingCar(carNameInput);
    }

    private static List<Integer> generateRandomNumbers(int carCount) {
        return new RandomNumber().generateNumbers(carCount);
    }
}