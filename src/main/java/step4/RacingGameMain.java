package step4;

import step4.domain.RacingGame;

import static step4.view.InputView.inputMessageAboutCars;
import static step4.view.InputView.inputMessageAboutTry;
import static step4.view.OutputView.*;

public class RacingGameMain {

    public static void main(String[] args) {

        String carNames = inputMessageAboutCars();
        RacingGame racingGame = new RacingGame(carNames);

        int numOfTry = inputMessageAboutTry();
        outputMessage();
        for (int i=0; i<numOfTry; i++) {
            outputMessageAboutMove(racingGame.moveCars());
        }
        outputMessageAboutWinner(racingGame.getCars().winnerCars());
    }


}
