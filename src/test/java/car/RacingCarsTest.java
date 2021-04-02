package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @DisplayName("play하면 racingCars는 움직여야 한다(?)")
    @Test
    public void playRacingGame() {
        // Arrange
        RacingCars racingCars = new RacingCars();

        // Act
        racingCars.play();

        // Assert
        // todo: assert racingCars
    }
}
