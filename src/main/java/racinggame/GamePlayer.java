package racinggame;

import racinggame.core.GameInitializer;
import racinggame.core.RacingGame;
import racinggame.core.gasstation.RandomGasStation;
import racinggame.view.GamePad;
import racinggame.view.ScoreScreen;
import racinggame.core.ScoreBoard;

public class GamePlayer {

    public static void main(String[] args) {
        GamePad.printCarNamesInputMsg();
        String carNames = GamePad.insertStringData();
        GamePad.printNumOfGameInputMsg();
        int numOfGame = GamePad.insertIntData();

        RacingGame racingGame = new RacingGame(
                GameInitializer.initCars(carNames),
                new RandomGasStation());
        ScoreBoard scoreBoard = racingGame.play(numOfGame);

        ScoreScreen.printScoreBoard(scoreBoard);
    }

}
