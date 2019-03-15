package racingcar;

import racingcar.domain.Car;
import racingcar.domain.InputReq;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.RacingResult;
import racingcar.view.WinnerUtils;

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

        while (racingGame.isEnd()) {
            racingGame.startRace();
            RacingResult turnResult = new RacingResult();
            OutputView.racingResultSave(turnResult, racingGame.getCars());
            OutputView.consolePrintRacingResult(turnResult);

            OutputView.printBlankLine();
        }

        List<Car> winners = WinnerUtils.topRankSearch(racingGame);
        System.out.println(OutputView.getWinnerNames(winners));
    }

}



