package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int BEGIN_INDEX = 0;
    private static int carCount, tryCount;
    private static ResultView resultView;
    private static InputView inputView;
    private static RacingCar racingCar;

    public static void main(String[] args) {
        makeObjects();

        resultView.questionCarCountMessage();
        carCount = inputView.getInput();

        resultView.questionTryCountMessage();
        tryCount = inputView.getInput();

        resultView.printNewLine();
        resultView.executeResultMessage();

        racingCar.initMoveCounts(carCount);

        for (int i = BEGIN_INDEX; i < tryCount; i++) {
            List<Integer> moveCounts = racingCar.makeMoveCounts(carCount);
            resultView.printMoveStateLines(moveCounts, carCount);
        }

        inputView.closeScanner();
    }

    private static void makeObjects() {
        resultView = new ResultView();
        inputView = new InputView();
        racingCar = new RacingCar(getMoveCounts());
    }

    private static List<Integer> getMoveCounts() {
        return new ArrayList<>();
    }
}