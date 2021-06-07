package racing.controller;

import racing.domain.CarMovable;
import racing.domain.Movable;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingMain {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();


    public static void main(String[] args) {
        String carNames = inputView.getCarNames();
        int tryNo = inputView.getTryNo();

        Movable movable = new CarMovable();

        RacingGame racingGame = new RacingGame(carNames, tryNo);
        while (!racingGame.isEnd()) {
            racingGame.race(movable);
        }

        resultView.printCars(racingGame.getRoundCars());
        resultView.printWinners(racingGame.getWinners());

    }
}
