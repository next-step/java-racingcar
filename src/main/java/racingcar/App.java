package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class App {
    public static void main(String[] args) {
        gameStart();
    }

    private static void gameStart() {
        InputReq inputReq = InputView.getInputData();
        String carNames = inputReq.getCarNames();
        int moveCount = inputReq.getMoveCount();

        RacingGame racingGame = new RacingGame(carNames, moveCount);

        RacingResult racingResult = null;
        while (racingGame.isEnd()) {
            racingResult = racingGame.startRace();
            OutputView.printResult(racingResult);
            OutputView.printBlankLine();

        }

        List<Car> winners = WinnerUtils.topRankSearch(racingResult);
        OutputView.PrintWinner(winners);
    }

}



