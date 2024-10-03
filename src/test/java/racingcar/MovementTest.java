package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovementTest {
    @Test
    @DisplayName("randomNumber가 4이상일 때 이동하는지 확인")
    void isMove_randomNumber_4이상() {
        Movement movement = new Movement();
        movement.randomNumber = 4;
        assertThat(movement.isMove()).isTrue();
    }

    @Test
    @DisplayName("randomNumber가 4미만일 때 이동하지 않는지 확인")
    void isMove_randomNumber_4이하() {
        Movement movement = new Movement();
        movement.randomNumber = 1;
        assertThat(movement.isMove()).isFalse();
    }
}
