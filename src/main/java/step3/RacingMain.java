package step3;

import step3.domain.RacingGame;
import step3.view.RacingInput;
import step3.view.RacingOutput;

public class RacingMain {

    public static void main(String[] args) {

        RacingInput racingInput = new RacingInput();
        RacingOutput racingOutput = new RacingOutput();

        String[] carNames = racingInput.inputForString();
        int gameCoin = racingInput.inputForInt();

        RacingGame racingGame = new RacingGame(carNames);

        for (int i = 0; i < gameCoin; i++) {
            racingOutput.printRacing(racingGame.moveCars());
        }

        racingOutput.printWinner(racingGame.findWinner());
    }
}

