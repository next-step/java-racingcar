package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 전진을 위한 정책을 위한 테스트")
class RandomIntMovementPolicyTest {
    private final MovementPolicy movablePolicy = () -> true;
    private final MovementPolicy unmovablePolicy = () -> false;

    @DisplayName("정책에서 자동차 전진이 가능한 경우 확인")
    @Test
    void checkMovableCasesInPolicyTest() {
        // then
        assertThat(movablePolicy.isMovable()).isTrue();
    }

    @DisplayName("정책에서 자동차 전진이 불가능한 경우 확인")
    @Test
    void checkUnmovableCasesInPolicyTest() {
        // then
        assertThat(unmovablePolicy.isMovable()).isFalse();
    }
}
