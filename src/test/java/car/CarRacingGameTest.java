package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRacingGameTest {

    @DisplayName("play하면 racingCars는 움직여야 한다(?)")
    @Test
    public void playRacingGame() {
        // Arrange
        CarRacingGame carRacingGame = new CarRacingGame();

        // Act
        carRacingGame.play();

        // Assert
        // todo: assert racingCars
    }
}
