package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovementConditionTest {

    @Test
    @DisplayName("랜덤값이 4미만일 경우 움직일 수 없는 상태이다.")
    void 랜덤값_4미만() {
        assertThat(new MovementCondition(3).isMovable()).isFalse();
    }

    @Test
    @DisplayName("랜덤값이 4이상일 경우 움직일 수 있는 상태이다.")
    void 랜덤값_4이상() {
        assertThat(new MovementCondition(4).isMovable()).isTrue();

    }

}