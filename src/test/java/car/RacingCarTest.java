package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @DisplayName("tryMoving은 차를 움직일 수도 있고 안 움직일 수도 있다(?)")
    @Test
    public void tryMoving() {
        // Arrange
        RacingCar racingCar = new RacingCar();

        // Act
        racingCar.tryMoving();

        // Assert
        // todo: assertion
    }

    @DisplayName("getMoveCount는 0이상 이동시도횟수 이하의 값을 반환해야 한다.")
    @Test
    public void getMoveCount() {
        // Arrange
        int tryCount = 5;
        RacingCar racingCar = new RacingCar();

        // Act
        for (int i = 0; i < tryCount; ++i) {
            racingCar.tryMoving();
        }
        int moveCount = racingCar.getMoveCount();

        // Assert
        assertThat(moveCount).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(tryCount);
    }
}
