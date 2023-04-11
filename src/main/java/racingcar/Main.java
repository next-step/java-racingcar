package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int BEGIN_INDEX = 0;
    public static final int INIT_VALUE = 0;
    public static final int PLUS_VALUE = 1;
    private static int carCount, tryCount;
    private static ResultView resultView;
    private static InputView inputView;
    private static RacingCar racingCar;
    private static List<Integer> moveCounts;

    public static void main(String[] args) {
        initObjects();

        resultView.questionCarCountMessage();
        carCount = inputView.getInput();

        resultView.questionTryCountMessage();
        tryCount = inputView.getInput();

        resultView.printNewLine();
        resultView.executeResultMessage();

        for (int i = BEGIN_INDEX; i < tryCount; i++) {
            initMoveCounts();
            createMoveCounts();
            printMoveStateLines();
            resultView.printNewLine();
        }

        inputView.closeScanner();
    }

    private static void initObjects() {
        resultView = new ResultView();
        inputView = new InputView();
        racingCar = new RacingCar();
        moveCounts = new ArrayList<>();
    }

    private static void printMoveStateLines() {
        for (int j = BEGIN_INDEX; j < carCount; j++) {
            printMoveStateLine(j);
        }
    }

    private static void printMoveStateLine(int j) {
        String moveStateLine = racingCar.makeCarMoveStateLine(moveCounts.get(j));
        resultView.printMoveStateLine(moveStateLine);
    }

    private static void createMoveCounts() {
        for (int j = BEGIN_INDEX; j < carCount; j++) {
            createMoveCount(j);
        }
    }

    private static void createMoveCount(int j) {
        if (moveYn()) {
            plusMoveCount(j);
        }
    }

    private static Integer plusMoveCount(int j) {
        return moveCounts.set(j, moveCounts.get(j) + PLUS_VALUE);
    }

    private static boolean moveYn() {
        return racingCar.moveYn(getRandomNumber());
    }

    private static int getRandomNumber() {
        return new RandomGenerator().getRandomNumber();
    }

    private static void initMoveCounts() {
        for (int j = BEGIN_INDEX; j < carCount; j++) {
            initMoveCount();
        }
    }

    private static boolean initMoveCount() {
        return moveCounts.add(INIT_VALUE);
    }
}