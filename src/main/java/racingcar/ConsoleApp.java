package racingcar;

import racingcar.domain.Car;
import racingcar.domain.InputReq;
import racingcar.domain.RacingGame;
import racingcar.view.*;

import java.util.List;

public class ConsoleApp {
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
            OutputView.racingResultSave(racingResult);
            OutputView.consolePrintRacingResult(racingResult);
            OutputView.printBlankLine();
        }

        List<Car> winners = WinnerUtils.topRankSearch(racingResult);
        System.out.println(OutputView.getWinnerNames(winners));
    }

}



