package racing;

import static racing.RacingGamePrinter.print;
import static racing.RacingGameScanner.enter;

public class RacingGameRunner {
    public static void main(String[] args) {
        print(RacingGame.of(new NumberMoreThanFourConditionStrategy(), enter()).run());
    }
}
