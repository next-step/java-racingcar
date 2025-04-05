package carrace.movement.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarMovementTest {

    @DisplayName("랜덤 값에 음수가 들어와서는 안됩니다.")
    @Test
    public void checkAndMoveForwardTest_NegativeRandomValue() {
        CarMovement carMovement = new CarMovement();
        int inputRandomValue = -9;

        assertThatThrownBy(() -> carMovement.checkAndMoveForward(inputRandomValue))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("랜덤 값에 9보다 큰 값이 들어와서는 안됩니다.")
    @Test
    public void checkAndMoveForwardTest_LargeThanNineRandomValue() {
        CarMovement carMovement = new CarMovement();
        int inputRandomValue = 10;

        assertThatThrownBy(() -> carMovement.checkAndMoveForward(inputRandomValue))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("랜덤 값에 4 ~ 9 사이의 값이 들어오면 한칸 전진합니다.")
    @Test
    public void checkAndMoveForwardTest_ValidRandomValueMove() {
        CarMovement carMovement = new CarMovement();
        int inputRandomValue = 5;
        int expectedPosition = 2; // current position = "-"
        carMovement.checkAndMoveForward(inputRandomValue);

        Assertions.assertThat(carMovement.get()).isEqualTo(expectedPosition);
    }

    @DisplayName("랜덤 값에 0 ~ 3 사이의 값이 들어오면 이동하지 않습니다.")
    @Test
    public void checkAndMoveForwardTest_ValidRandomValueStop() {
        CarMovement carMovement = new CarMovement();
        int inputRandomValue = 2;
        int expectedPosition = 1; // current position = "-"
        carMovement.checkAndMoveForward(inputRandomValue);

        Assertions.assertThat(carMovement.get()).isEqualTo(expectedPosition);
    }

    @DisplayName("한칸 전진시 이전 값보다 -가 하나 증가해야합니다.")
    @Test
    public void moveForward_ValidMove() {
        CarMovement carMovement = new CarMovement();
        int expectedPosition = 2; // current position = "-"
        carMovement.moveForward();

        Assertions.assertThat(carMovement.get()).isEqualTo(expectedPosition);
    }
}
