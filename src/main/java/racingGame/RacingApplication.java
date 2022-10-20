package racingGame;

import racingGame.strategy.MoveAbleStrategy;
import racingGame.strategy.RandomNumberGenerate;

import static racingGame.view.InputView.*;
import static racingGame.view.ResultView.*;

public class RacingApplication {

    public static void main(String[] args) {

        RacingGame racingGame = new RacingGame(
                 new MoveAbleStrategy()
                ,new RandomNumberGenerate());

        racingGame.race();
    }
}
