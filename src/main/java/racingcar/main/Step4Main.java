package racingcar.main;

import racingcar.WinningRacingCar;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class Step4Main {

    public static void main(String[] args) {
        ResultView resultView = createResultView();
        InputView inputView = createInputView();

        resultView.printInputCarNameMessage();
        String carNameInput = inputView.getStringInput();

        resultView.printQuestionTryCountMessage();
        int tryCount = inputView.getIntegerInput();

        resultView.printNewLine();
        resultView.printExecuteResultMessage();

        WinningRacingCar racingCarWinner = createWinningRacingCar(carNameInput);

        inputView.closeScanner();
    }

    private static WinningRacingCar createWinningRacingCar(String carNameInput) {
        return new WinningRacingCar(carNameInput);
    }

    private static ResultView createResultView() {
        return new ResultView();
    }

    private static InputView createInputView() {
        return new InputView();
    }
}