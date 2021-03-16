package step3;

import org.junit.jupiter.api.Test;
import step3.service.GameRule;
import step3.utils.RandomGenerator;
import step3.utils.RandomUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameRuleTest {

    @Test
    void isMove() {
        // given
        RandomGenerator randomGenerator = new RandomUtil();
        GameRule rule = new GameRule(randomGenerator);

        boolean expected = randomGenerator.getRandom() >= 4;

        // when
        boolean actual = rule.isMove();

        // then
        assertEquals(actual, expected);
    }
}
