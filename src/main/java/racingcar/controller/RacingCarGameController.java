package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.dto.FinalScoreBoard;
import racingcar.dto.RacingCarGameRequest;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGameController {

    public static void run() {
        RacingCarGame racingCarGame = createRacingCarGame();
        while (!racingCarGame.isDone()) {
            racingCarGame.play();
        }
        printResult(racingCarGame.getFinalScoreBoard());
    }

    private static RacingCarGame createRacingCarGame() {
        try {
            return new RacingCarGame(InputView.getUserInput());
        } catch (IllegalArgumentException exception) {
            InputView.printWrongInputMessage();
            return createRacingCarGame();
        }
    }

    private static void printResult(FinalScoreBoard finalScoreBoard) {
        ResultView.printFinalResult(finalScoreBoard);
    }
}
