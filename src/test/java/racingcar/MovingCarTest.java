package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovingCarTest {

    @Test
    @DisplayName("숫자가 MOVABLE보다 크면 이동이 가능하다.")
    void isMove() {
        MovingCar movingCar = new MovingCar();

        int moveAvail = 5;

        assertTrue(movingCar.isMove(moveAvail));
    }

    @Test
    @DisplayName("숫자가 MOVABLE보다 작으면 이동이 불가능하다.")
    void invalidMove() {
        MovingCar movingCar = new MovingCar();

        int invalidMove = 3;

        assertFalse(movingCar.isMove(invalidMove));
    }
}