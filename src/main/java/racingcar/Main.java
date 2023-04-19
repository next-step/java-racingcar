package racingcar;

import racingcar.domain.CarRacingGame;
import racingcar.domain.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.ResultView;

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

        CarRacingGame carRacingGame = createWinningRacingCar(carNameInput);

        for (int i = BEGIN_INDEX; i < tryCount; i++) {
            resultView.printCarNameAndMoveStateLines(
                    carRacingGame.makeMoveCounts(
                            generateRandomNumbers(carRacingGame.carsSize()))
            );
        }
        resultView.printWinners(carRacingGame.winningCars());

        inputView.closeScanner();
    }

    private static ResultView createResultView() {
        return new ResultView();
    }

    private static InputView createInputView() {
        return new InputView();
    }

    private static CarRacingGame createWinningRacingCar(String carNameInput) {
        return new CarRacingGame(carNameInput);
    }

    private static List<Integer> generateRandomNumbers(int carCount) {
        return new RandomNumber().generateNumbers(carCount);
    }
}