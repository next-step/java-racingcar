package racing;

import static racing.RacingGamePrinter.print;
import static racing.RacingGameScanner.enter;

public class RacingGameRunner {
    public static void main(String[] args) {
        NumberMoreThanFourConditionStrategy strategy = NumberMoreThanFourConditionStrategy.getInstance();
        int[] enter = enter();
        print(RacingGame.of(strategy, enter[0], enter[1]).run());
    }
}
