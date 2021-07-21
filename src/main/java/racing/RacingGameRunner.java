package racing;

import static racing.RacingGamePrinter.print;
import static racing.RacingGameScanner.*;

public class RacingGameRunner {
    public static void main(String[] args) {
        ForwardStrategy strategy = new NumberMoreThanFour();
        print(RacingGame.from(strategy, enter()).run());
    }
}
