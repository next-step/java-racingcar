package racingGame.racingRule;

import java.util.Random;

public class RacingRuleDefault implements RacingRule{
    private static  int maxNum = 10;
    private static  int limitNum = 4;
    private static Random random = new Random();
    @Override
    public boolean createRandomResult() {
        return random.nextInt(maxNum) >= limitNum;
    }
}
