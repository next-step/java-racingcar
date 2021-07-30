package racing;

import racing.model.Racing;
import racing.view.RacingView;

public class RacingGame {

    private int gameCount = 0;

    public RacingGame(int gameCount) {
        this.gameCount = gameCount;
    }

    public void gameStart(Racing racing) {
        int count = 0;
        while (count < gameCount) {
            racing.game();
            count++;
        }
        RacingView.printWinner(racing.winnerCarList());
    }

}
