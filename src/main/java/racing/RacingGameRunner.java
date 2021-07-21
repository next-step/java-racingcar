package racing;

import static racing.RacingGamePrinter.print;
import static racing.RacingGameScanner.*;

public class RacingGameRunner {
    public static void main(String[] args) {
        print(RacingGame.from(new NumberMoreThanFourStrategy(), enter()).run());
    }
}
