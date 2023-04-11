package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        InputView inputView = new InputView();
        RacingCar racingCar = new RacingCar();

        resultView.questionCarCountMessage();
        int carCount = inputView.getInput();

        resultView.questionTryCountMessage();
        int tryCount = inputView.getInput();

        inputView.finishInput();

        resultView.printNewLine();

        List<Integer> moveCounts = new ArrayList<>();
        resultView.executeResultMessage();
        for (int i = 0; i < tryCount; i++) {

            for(int j = 0; j < carCount; j++) {
                moveCounts.add(0);
            }

            for (int j = 0; j < carCount; j++) {
                if (racingCar.moveYn(new RandomGenerator().getRandomNumber())) {
                    moveCounts.set(j, moveCounts.get(j) + 1);
                }
            }

            for (int j = 0; j < carCount; j++) {
                String moveStateLine = racingCar.makeCarMoveStateLine(moveCounts.get(j));
                resultView.printMoveStateLine(moveStateLine);
            }

            resultView.printNewLine();
        }
    }
}