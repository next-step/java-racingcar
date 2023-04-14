package racingcar;

import java.util.List;

public class Main {
    public static final int BEGIN_INDEX = 0;
    private static int carCount, tryCount;
    private static ResultView resultView;
    private static InputView inputView;
    private static RacingCar racingCar;

    public static void main(String[] args) {
        createUI();

        resultView.questionCarCountMessage();
        carCount = inputView.getInput();

        resultView.questionTryCountMessage();
        tryCount = inputView.getInput();

        resultView.printNewLine();
        resultView.executeResultMessage();

        createRacingCar();

        for (int i = BEGIN_INDEX; i < tryCount; i++) {
            List<Integer> moveCounts = racingCar.makeMoveCounts(carCount);
            resultView.printMoveStateLines(moveCounts, carCount);
        }

        inputView.closeScanner();
    }

    private static void createRacingCar() {
        racingCar = new RacingCar(carCount);
    }

    private static void createUI() {
        resultView = new ResultView();
        inputView = new InputView();
    }
}