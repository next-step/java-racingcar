package racingcar.domain.movement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @ValueSource(ints = {4, 9})
    @DisplayName("movable 메서드에 이동 가능한 조건에 해당하는 숫자를 전달하는 경우, true를 반환한다.")
    void movable_ForwardCondition(final int condition) {
        assertThat(rule.movable(condition))
                .isTrue();
    }

    @Test
    @DisplayName("movable 메서드에 정지 조건에 해당하는 숫자를 전달하는 경우, false를 반환한다.")
    void movable_StopCondition() {
        final int stopCondition = 3;

        assertThat(rule.movable(stopCondition))
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("movable 메서드에 범위가 벗어난 조건에 해당하는 숫자를 전달하는 경우, 예외를 던진다.")
    void movable_ConditionOutOfRange_Exception(final int conditionOutOfRange) {
        assertThatThrownBy(() -> rule.movable(conditionOutOfRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 전진/정지 조건은 0이상 9이하의 자연수만 가능합니다.");
    }
}
