package racinggame;

import racinggame.domain.car.CarsInitializer;
import racinggame.domain.RacingGame;
import racinggame.domain.gasstation.RandomGasStation;
import racinggame.domain.scoreboard.ScoreBoard;
import racinggame.view.GamePad;
import racinggame.view.ScoreScreen;

public class GamePlayer {

    public static void main(String[] args) {
        GamePad.printCarNamesInputMsg();
        String carNames = GamePad.insertStringData();
        GamePad.printNumOfRoundInputMsg();
        int numOfRound = GamePad.insertIntData();

        RacingGame racingGame = new RacingGame(
                CarsInitializer.initCars(carNames),
                new RandomGasStation());
        ScoreBoard scoreBoard = racingGame.play(numOfRound);

        ScoreScreen.printScoreBoard(scoreBoard);
        ScoreScreen.printWinner(scoreBoard);
    }

}
