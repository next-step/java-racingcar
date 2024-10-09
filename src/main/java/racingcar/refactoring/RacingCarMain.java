package racingcar.refactoring;

import racingcar.refactoring.controller.GameController;
import racingcar.refactoring.domain.GameResult;
import racingcar.refactoring.domain.RoundResult;
import racingcar.refactoring.view.ResultView;

import java.util.List;
import java.util.Map;

import static racingcar.refactoring.view.InputView.howManyTry;
import static racingcar.refactoring.view.InputView.inputCarsNames;


public class RacingCarMain {

    public static void main(String[] args) {
        GameController game = new GameController(inputCarsNames());
        GameResult gameResults = game.start(howManyTry());

        printGameResultDescription();
        printRoundResults(gameResults.getRoundResults());
        printWinnersName(gameResults.findWinners());
    }

    private static void printGameResultDescription() {
        ResultView.showResultDescription();
    }

    private static void printRoundResults(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            printRoundResult(roundResult);
        }
    }

    private static void printRoundResult(RoundResult roundResult) {
        for (Map.Entry<String, Integer> entry : roundResult.getEntrySet()) {
            ResultView.showCarNameAndResult(entry.getKey(), entry.getValue());
        }
        ResultView.nextLine();
    }

    private static void printWinnersName(List<String> winners) {
        ResultView.printWinnersName(winners);
    }
}
