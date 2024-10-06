package racingcar.refactoring;

import racingcar.refactoring.controller.GameController;
import racingcar.refactoring.domain.GameResult;
import racingcar.refactoring.view.ResultView;

import java.util.List;
import java.util.Map;

import static racingcar.refactoring.view.InputView.howManyTry;
import static racingcar.refactoring.view.InputView.inputCarsNames;


public class RacingCarMain {

    public static void main(String[] args) {
        GameController game = new GameController(inputCarsNames(), howManyTry());
        GameResult gameResults = game.start();

        printGameResultDescription();
        printRoundResults(gameResults.getRoundResults());
        printWinnersName(gameResults.findWinners());
    }

    private static void printGameResultDescription() {
        ResultView.showResultDescription();
    }

    private static void printRoundResults(List<Map<String, Integer>> gameResults) {
        for (Map<String, Integer> gameResult : gameResults) {
            printRoundResult(gameResult);
        }
    }

    private static void printRoundResult(Map<String, Integer> gameResult) {
        for (Map.Entry<String, Integer> entry : gameResult.entrySet()) {
            ResultView.showCarNameAndResult(entry.getKey(), entry.getValue());
        }
        ResultView.nextLine();
    }

    private static void printWinnersName(List<String> winners) {
        ResultView.printWinnersName(winners);
    }
}
