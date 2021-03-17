package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.service.GameRule;
import step3.utils.NumberGenerator;
import step3.utils.RandomUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameRuleTest {

    @Test
    @DisplayName("랜덤 숫자의 조건에 따라 동작여부 결정 테스트")
    void isMovable() {
        // given
        NumberGenerator numberGenerator = new RandomUtil();
        GameRule rule = new GameRule(numberGenerator);

        boolean expected = numberGenerator.getRandom() >= 4;

        // when
        boolean actual = rule.isMovable();

        // then
        assertEquals(actual, expected);
    }
}
