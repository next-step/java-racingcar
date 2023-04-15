package racingcar;

import java.util.List;

public class Main {

    public static final int BEGIN_INDEX = 0;

    public static void main(String[] args) {
        ResultView resultView = createResultView();
        InputView inputView = createInputView();

        resultView.questionCarCountMessage();
        int carCount = inputView.getInput();

        resultView.questionTryCountMessage();
        int tryCount = inputView.getInput();

        resultView.printNewLine();
        resultView.executeResultMessage();

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