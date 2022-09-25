package step3.racinggame;

import step3.racinggame.core.GameInitializer;
import step3.racinggame.core.RacingGame;
import step3.racinggame.core.ScoreBoard;
import step3.racinggame.core.gasstation.RandomGasStation;
import step3.racinggame.view.GamePad;
import step3.racinggame.view.ScoreScreen;

public class GamePlayer {

    public static void main(String[] args) {
        GamePad.printNumOfCarInputMsg();
        int numOfCar = GamePad.insertData();
        GamePad.printNumOfGameInputMsg();
        int numOfGame = GamePad.insertData();

        RacingGame racingGame = new RacingGame(GameInitializer.initCars(numOfCar), new RandomGasStation());
        ScoreBoard scoreBoard = racingGame.play(numOfGame);

        ScoreScreen.printScoreBoard(scoreBoard);
    }

}
