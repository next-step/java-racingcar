package step3;

import step3.strategy.draw.UnderscoreDrawStrategy;
import step3.strategy.move.RandomMoveStrategy;
import step3.view.InputView;
import step3.view.PrintView;

public class RacingCarApplication {
    public static void main(String[] args) {

        RacingGame racingGame = RacingGame.of(InputView.getInstance(), PrintView.of(UnderscoreDrawStrategy.getInstance()), RandomMoveStrategy.getInstance());
        racingGame.execute();
    }

}
