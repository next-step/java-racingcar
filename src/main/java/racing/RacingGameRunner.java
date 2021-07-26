package racing;

import racing.domain.RacingGame;
import racing.strategy.NumberMoreThanFourConditionStrategy;
import racing.util.RacingGamePrinter;

import static java.lang.Integer.parseInt;
import static racing.util.RacingGameScanner.enter;

public class RacingGameRunner {
    public static void main(String[] args) {
        String[] enter = enter();
        RacingGame game = RacingGame.init(NumberMoreThanFourConditionStrategy.getInstance(),
                                          enter[0], parseInt(enter[1]));

        RacingGamePrinter printer = new RacingGamePrinter();
        printer.print(game.run());
    }
}
