package ch01.racinggame;

import ch01.racinggame.Domain.InputData;
import ch01.racinggame.Domain.RacingGame;
import ch01.racinggame.view.InputView;
import ch01.racinggame.view.ResultView;

public class Main {

    public static void main(String[] args) {
        //Input data
        InputView iv = new InputView();
        InputData inputData = iv.getInputData();

        //start a racing game
        RacingGame racingGame = new RacingGame(inputData);


        ResultView rv = new ResultView();
        //start racing game
        for (int i = 0; i < racingGame.getAttemptCount(); i++) {

            //racingGame.start();

            //show a result of racing game
            rv.showResult(racingGame);
        }

    }
}
