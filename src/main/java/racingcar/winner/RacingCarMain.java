package racingcar.winner;

import racingcar.winner.controller.GameController;
import racingcar.winner.domain.GameResult;
import racingcar.winner.utils.StringUtils;
import racingcar.winner.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static racingcar.winner.view.InputView.*;

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
