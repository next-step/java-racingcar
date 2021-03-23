package ch01.racinggame;

import ch01.racinggame.Domain.Car;
import ch01.racinggame.Domain.InputData;
import ch01.racinggame.Domain.RacingGame;
import ch01.racinggame.view.InputView;
import ch01.racinggame.view.ResultView;

public class Main {

    public static void main(String[] args) {
        //Input data
        InputView iv = new InputView();
        InputData inputData = iv.getInputData();

        //create a game
        RacingGame racingGame = new RacingGame(inputData);
        ResultView rv = new ResultView();

        //start a racing game
        for (int i = 0; i < racingGame.attemptCount(); i++) {

            Car[] cars = racingGame.start();
            rv.showResult(cars);
        }

        //show a result of racing game
        rv.showWinnerResult(racingGame.winner().winnerCars());
    }
}
