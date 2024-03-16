package racingcar.domain.movement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.config.RacingCarException.MOVEMENT_CONDITION_OUT_OF_RANGE;
import static racingcar.domain.movement.BasicRule.FORWARD_CONDITION;
import static racingcar.domain.movement.BasicRule.MAXIMUM_CONDITION;
import static racingcar.domain.movement.BasicRule.MINIMUM_CONDITION;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.TestRacingCarConfig;

class BasicRuleTest {

    private static Rule rule;

    @BeforeAll
    static void setUp() {
        rule = TestRacingCarConfig.basicRule();
    }

    @ParameterizedTest
    @ValueSource(ints = {FORWARD_CONDITION, MAXIMUM_CONDITION})
    @DisplayName("movable 메서드에 이동 가능한 조건에 해당하는 숫자를 전달하는 경우, true를 반환한다.")
    void movable_ForwardCondition(final int condition) {
        assertThat(rule.movable(condition))
                .isTrue();
    }

    @Test
    @DisplayName("movable 메서드에 정지 조건에 해당하는 숫자를 전달하는 경우, false를 반환한다.")
    void movable_StopCondition() {
        assertThat(rule.movable(FORWARD_CONDITION - 1))
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {MINIMUM_CONDITION - 1, MAXIMUM_CONDITION + 1})
    @DisplayName("movable 메서드에 범위가 벗어난 조건에 해당하는 숫자를 전달하는 경우, 예외를 던진다.")
    void movable_ConditionOutOfRange_Exception(final int conditionOutOfRange) {
        assertThatThrownBy(() -> rule.movable(conditionOutOfRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MOVEMENT_CONDITION_OUT_OF_RANGE.message(conditionOutOfRange));
    }
}
