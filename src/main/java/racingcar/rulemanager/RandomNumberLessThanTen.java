package racingcar.rulemanager;

import java.util.Random;

public class RandomNumberLessThanTen implements RuleManager{
    private static final int RULE_COUNT = 10;
    @Override
    public int getRandomNum() {
        return new Random().nextInt(RULE_COUNT);
    }
}
