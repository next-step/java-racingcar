package racingcar.main;

import racingcar.RandomNumber;
import racingcar.WinningRacingCar;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class Step4Main {

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

        WinningRacingCar winningRacingCar = createWinningRacingCar(carNameInput);

        for (int i = BEGIN_INDEX; i < tryCount; i++) {
            resultView.printCarNameAndMoveStateLines(
                    winningRacingCar.makeCars(
                            generateRandomNumbers(winningRacingCar.getCarsSize()))
            );
        }
        resultView.printWinners(winningRacingCar.getWinnerNames());

        inputView.closeScanner();
    }

    private static ResultView createResultView() {
        return new ResultView();
    }

    private static InputView createInputView() {
        return new InputView();
    }

    private static WinningRacingCar createWinningRacingCar(String carNameInput) {
        return new WinningRacingCar(carNameInput);
    }

    private static List<Integer> generateRandomNumbers(int carCount) {
        return new RandomNumber().generateNumbers(carCount);
    }
}