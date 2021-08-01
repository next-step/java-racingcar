package racing;

import racing.model.Racing;
import racing.model.RandomMovingStrategy;
import racing.view.RacingView;

public class RacingGame {

    private int gameCount = 0;

    public RacingGame(int gameCount) {
        this.gameCount = gameCount;
    }

    public void gameStart(Racing racing) {
        do {
            racing.game();
            RacingView.printCarMove(racing);
        } while (!endGame());
        RacingView.printWinner(racing.winnerCarList());
    }

    public Boolean endGame() {
        if (this.gameCount > 0) {
            this.gameCount--;
        }
        return gameCount == 0;
    }

}
