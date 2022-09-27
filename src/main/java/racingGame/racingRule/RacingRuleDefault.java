package racingGame.racingRule;

import java.util.Random;

public class RacingRuleDefault implements RacingRule{
    @Override
    public boolean createRandomResult() {
        int maxNum = 10;
        int limitNum = 4;
        Random random = new Random();
        return random.nextInt(maxNum) >= limitNum;
    }
}
