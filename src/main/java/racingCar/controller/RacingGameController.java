package racingCar.controller;

import racingCar.model.RacingGame;
import racingCar.model.RandomMovingStrategy;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class RacingGameController {
    public void run() {
        String[] carNames = InputView.getCarNames();
        int playCount = InputView.getPlayCount();

        RacingGame racingGame = new RacingGame(carNames, playCount);

        System.out.println("\n실행결과");
        for(int i=0; i<racingGame.getPlayCount(); i++) {
            ResultView.printCarsLocation(racingGame.moveCars(new RandomMovingStrategy()));
        }
        ResultView.printWinner(racingGame.findWinners());
    }
}
