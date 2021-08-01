package racing;

import racing.model.Car;
import racing.model.Racing;
import racing.model.RandomMovingStrategy;
import racing.view.RacingView;

import java.util.List;

public class RacingGame {

    private int gameCount = 0;

    public RacingGame(int gameCount) {
        this.gameCount = gameCount;
    }

    public List<Car> gameStart(Racing racing) {
        List<Car> carList;
        do {
            carList = racing.game();
            RacingView.printCarMove(carList);
        } while (!endGame());
        RacingView.printWinner(racing.winnerCarList());
        return carList;
    }

    public Boolean endGame() {
        if (this.gameCount > 0) {
            this.gameCount--;
        }
        return gameCount == 0;
    }

}
