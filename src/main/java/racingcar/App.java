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

        RacingGame racingGame = new RacingGame(inputReq);
        racingGame.startRace();

        List<Car> cars = racingGame.getCars();
        List<Car> winners = WinnerUtils.topRankSearch(cars);
        OutputView.PrintWinner(winners);
    }

}



