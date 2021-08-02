package racing.controller;

import racing.model.Car;
import racing.model.Racing;
import racing.view.Output;

import java.util.List;

public class RacingGame {

    private static final int END_GAME_COUNT = 0;
    private int gameCount;

    public RacingGame(int gameCount) {
        this.gameCount = gameCount;
    }

    public void gameStart(Racing racing) {
        List<Car> carList;
        do {
            carList = racing.game();
            Output.printCarMove(carList);
        } while (!endGame());
        Output.printWinner(racing.winnerCarList());
    }

    public Boolean endGame() {
        if (this.gameCount > END_GAME_COUNT) {
            this.gameCount--;
        }
        return gameCount == END_GAME_COUNT;
    }

}
