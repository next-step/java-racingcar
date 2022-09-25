package racinggame;

import racinggame.core.GameInitializer;
import racinggame.core.RacingGame;
import racinggame.core.gasstation.RandomGasStation;
import racinggame.view.GamePad;
import racinggame.view.ScoreScreen;
import racinggame.core.ScoreBoard;

public class GamePlayer {

    public static void main(String[] args) {
        GamePad.printNumOfCarInputMsg();
        int numOfCar = GamePad.insertData();
        GamePad.printNumOfGameInputMsg();
        int numOfGame = GamePad.insertData();

        RacingGame racingGame = new RacingGame(
                GameInitializer.initCars(numOfCar), new RandomGasStation());
        ScoreBoard scoreBoard = racingGame.play(numOfGame);

        ScoreScreen.printScoreBoard(scoreBoard);
    }

}
