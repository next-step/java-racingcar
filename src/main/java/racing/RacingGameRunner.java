package racing;

import racing.strategy.NumberMoreThanFourConditionStrategy;
import racing.domain.RacingGame;

import static racing.util.RacingGamePrinter.print;
import static racing.util.RacingGameScanner.enterNames;
import static racing.util.RacingGameScanner.enterStageCount;

public class RacingGameRunner {
    public static void main(String[] args) {
        NumberMoreThanFourConditionStrategy strategy = NumberMoreThanFourConditionStrategy.getInstance();
        RacingGame game = RacingGame.init(strategy, enterNames(), enterStageCount());
        print(game.run());
    }
}
