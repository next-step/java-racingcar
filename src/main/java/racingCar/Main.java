package racingCar;

import racingCar.Application.RacingGame;
import racingCar.UI.InputView;
import racingCar.UI.ResultView;

public class Main {
    public static void main(String[] args) {
        //Input
        InputView inputView = new InputView();
        RacingGame racingGame = inputView.setStartInput();

        // Racing Game
        racingGame.initRacingCars();
        racingGame.move();

        //Output
        ResultView resultView = new ResultView();
        resultView.printResult(racingGame.getRacingCarList(), racingGame.getTime());
    }
}

