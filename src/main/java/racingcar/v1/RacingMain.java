package racingcar.v1;

import racingcar.v1.domain.RacingGame;
import racingcar.v1.ui.View;

public class RacingMain {

    public static void main(String[] args) {

        String carNames = View.inputNames();
        int rotation = View.inputRotationCount();

        RacingGame racingGame = new RacingGame(carNames, rotation);
        while(!racingGame.isEnd()) {
            racingGame.playSingleLoop();
            View.printRace(racingGame.getCarList());
        }
        View.printWinner(racingGame.getWinners());
    }
}
