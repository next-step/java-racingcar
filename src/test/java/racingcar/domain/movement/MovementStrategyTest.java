package racingcar.domain.movement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.TestRacingCarConfig;

class MovementStrategyTest {

    private static MovementStrategy basicMoveForwardStrategy;
    private static MovementStrategy basicStopStrategy;

    @BeforeAll
    static void setUp() {
        basicMoveForwardStrategy = TestRacingCarConfig.basicMoveForwardStrategy();
        basicStopStrategy = TestRacingCarConfig.basicStopStrategy();
    }

    @Test
    @DisplayName("canMoveForward 메서드는 자동차 이동 전략에 따라 전진 조건에 해당하면, true를 반환한다.")
    void canMoveForward_ForwardCondition_True() {
        assertThat(basicMoveForwardStrategy.canMoveForward())
                .isTrue();
    }

    @Test
    @DisplayName("canMoveForward 메서드는 자동차 이동 전략에 따라 정지 조건에 해당하면, false를 반환한다.")
    void canMoveForward_StopCondition_False() {
        assertThat(basicStopStrategy.canMoveForward())
                .isFalse();
    }
}
