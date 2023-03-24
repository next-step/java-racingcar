package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RacingRuleTest {

    @DisplayName("4 이상의 입력이 들어오면 전진 확인")
    @ParameterizedTest
    @ValueSource(ints = {4, 6, 9})
    void attackTest(int attackNumber) {
        RacingRule rule = new RacingRule();
        boolean actual = rule.isAttackable(attackNumber);
        assertTrue(actual);
    }

    @DisplayName("4 미만의 입력이 들어오면 정지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void failAttackTest(int attackNumber) {
        RacingRule rule = new RacingRule();
        boolean actual = rule.isAttackable(attackNumber);
        assertFalse(actual);
    }

}