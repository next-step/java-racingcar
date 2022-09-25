package racinggame;

import racinggame.core.GameInitializer;
import racinggame.core.RacingGame;
import racinggame.core.gasstation.RandomGasStation;
import racinggame.core.scoreboard.ScoreBoard;
import racinggame.view.GamePad;
import racinggame.view.ScoreScreen;

public class GamePlayer {

    public static void main(String[] args) {
        GamePad.printCarNamesInputMsg();
        String carNames = GamePad.insertStringData();
        GamePad.printNumOfRoundInputMsg();
        int numOfRound = GamePad.insertIntData();

        RacingGame racingGame = new RacingGame(
                GameInitializer.initCars(carNames),
                new RandomGasStation());
        ScoreBoard scoreBoard = racingGame.play(numOfRound);

        ScoreScreen.printScoreBoard(scoreBoard);
    }

}
