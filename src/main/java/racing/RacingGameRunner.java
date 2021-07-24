package racing;

import racing.domain.NumberMoreThanFourConditionStrategy;
import racing.domain.RacingGame;

import static racing.util.RacingGamePrinter.print;
import static racing.util.RacingGameScanner.enter;

public class RacingGameRunner {
    public static void main(String[] args) {
        NumberMoreThanFourConditionStrategy strategy = NumberMoreThanFourConditionStrategy.getInstance();
        int[] enter = enter();
        RacingGame game = RacingGame.of(strategy, enter[0], enter[1]);
        print(game.run());
    }
}
