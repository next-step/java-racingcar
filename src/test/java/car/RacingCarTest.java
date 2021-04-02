package car;

import car.domain.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @DisplayName("move는 차를 움직인다")
    @Test
    public void tryMoving() {
        // Arrange
        RacingCar racingCar = new RacingCar();

        // Act
        racingCar.move();

        // Assert
        assertThat(racingCar.getMoveCount()).isEqualTo(0);
    }

    @DisplayName("getMoveCount는 moveCount를 반환해야 한다.")
    @Test
    public void getMoveCount() {
        // Arrange
        int moveCount = 5;
        RacingCar racingCar = new RacingCar();

        // Act
        for (int i = 0; i < moveCount; ++i) {
            racingCar.move();
        }
        int result = racingCar.getMoveCount();

        // Assert
        assertThat(moveCount).isEqualTo(result);
    }
}
