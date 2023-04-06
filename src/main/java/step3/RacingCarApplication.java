package step3;

import step3.strategy.RandomMoveStrategy;
import step3.view.InputView;
import step3.view.PrintView;

public class RacingCarApplication {
    public static void main(String[] args) {

        RacingGame racingGame = new RacingGame(new InputView(), new PrintView(), new RandomMoveStrategy());

        racingGame.execute();
    }

}
