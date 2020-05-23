package step3;

import step3.controller.RacingController;
import step3.domain.RacingGame;
import step3.view.RacingInput;
import step3.view.RacingOutput;

public class RacingMain {

    public static void main(String[] args) {

        RacingController racingController = new RacingController();

        String[] carNames = racingController.inputForStringController();
        int gameCoin = racingController.inputForIntController();

        RacingGame racingGame = new RacingGame(carNames);

        for (int i = 0; i < gameCoin; i++) {
            racingController.outputCars(racingGame.moveCars());
        }

        racingController.outputWinners(racingGame.findWinner());
    }
}

