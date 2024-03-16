package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestRacingCarConfig.basicRule;
import static racingcar.TestRacingCarConfig.moveForwardNumberGenerator;
import static racingcar.TestRacingCarConfig.stopNumberGenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovementStrategyTest {

    @Test
    @DisplayName("자동차 이동 규칙과 조건수 생성기를 전달하여 자동차 이동 전략 객체를 생성한다.")
    void new_RuleAndNumberGenerator_MovementStrategy() {
        assertThat(new MovementStrategy(basicRule(), moveForwardNumberGenerator()))
                .isNotNull();
    }

    @Test
    @DisplayName("canMoveForward 메서드는 자동차 이동 전략에 따라 전진 조건에 해당하면, true를 반환한다.")
    void canMoveForward_ForwardCondition_True() {
        final MovementStrategy movementForwardStrategy = new MovementStrategy(
                basicRule(),
                moveForwardNumberGenerator()
        );

        assertThat(movementForwardStrategy.canMoveForward())
                .isTrue();
    }

    @Test
    @DisplayName("canMoveForward 메서드는 자동차 이동 전략에 따라 정지 조건에 해당하면, false를 반환한다.")
    void canMoveForward_StopCondition_False() {
        final MovementStrategy movementStopStrategy = new MovementStrategy(basicRule(), stopNumberGenerator());

        assertThat(movementStopStrategy.canMoveForward())
                .isFalse();
    }
}
