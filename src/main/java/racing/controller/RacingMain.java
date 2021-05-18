package racing.controller;

import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingMain {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();


    public static void main(String[] args) {
        String carNames = inputView.getCarNames();
        int tryNo = inputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo);
        while (!racingGame.isEnd()) {
            racingGame.race();
        }

        resultView.printCars(racingGame.getRoundCars());
        resultView.printWinners(racingGame.getWinners());

    }
}
