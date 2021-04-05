package car;

import car.domain.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @DisplayName("move는 moveCount를 1 증가시킨다.")
    @Test
    public void moveThenMoveCountMustIncrease() {
        // Arrange
        RacingCar racingCar = new RacingCar("Glory");

        // Act
        racingCar.move();

        // Assert
        assertThat(racingCar.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("getMoveCount는 moveCount를 반환해야 한다.")
    @Test
    public void getMoveCountMustReturnMoveCount() {
        // Arrange
        int moveCount = 5;
        RacingCar racingCar = new RacingCar("Grace");

        // Act
        for (int i = 0; i < moveCount; ++i) {
            racingCar.move();
        }
        int result = racingCar.getMoveCount();

        // Assert
        assertThat(moveCount).isEqualTo(result);
    }

    @DisplayName("RacingCar를 생성하면 getCarName은 생성자에 지정한 carName을 반환해야 한다.")
    @Test
    public void getCarNameThenReturnCarNameEnteredOnConstruction() {
        // Arrange
        String carName = "Worshipper";

        // Act
        RacingCar racingCar = new RacingCar(carName);

        // Assert
        assertThat(racingCar.getCarName()).isEqualTo(carName);
    }
}
