package racingcar.rule;

import java.util.Random;

public class RandomRacingRule implements RacingRule {

    private final Random random = new Random();

    /**
     * 0 ~ 9 사이의 랜덤한 숫자를 만듭니다.
     * @return
     */
    @Override
    public int getNumber() {
        return this.random.nextInt(RandomRacingRule.MAX_BOUND);
    }
}
