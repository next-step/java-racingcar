package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Movement;
import racingcar.utils.TestMovement;

import static org.assertj.core.api.Assertions.assertThat;

class MovementTest {
    @Test
    @DisplayName("random값이 4이상일 때 이동하는지 확인")
    void isMove_randomNumber_4이상() {
        Movement movement = new TestMovement(4);
        assertThat(movement.isMove()).isTrue();
    }

    @Test
    @DisplayName("random값이 4미만일 때 이동하지 않는지 확인")
    void isMove_randomNumber_4미만() {
        Movement movement = new TestMovement(3);
        assertThat(movement.isMove()).isFalse();
    }
}
