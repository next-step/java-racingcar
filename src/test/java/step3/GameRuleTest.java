package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.service.GameRule;
import step3.utils.NumberGenerator;
import step3.utils.RandomUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameRuleTest {

    @ParameterizedTest(name = "랜덤 숫자의 조건에 따라 동작여부 결정 테스트")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void isMovable(int number) {
        // given
        NumberGenerator numberGenerator = new RandomUtil();
        GameRule rule = new GameRule(numberGenerator);

        boolean expected = number >= 4;

        // when
        boolean actual = rule.isMovableTest(number);

        // then
        assertEquals(actual, expected);
    }
}
