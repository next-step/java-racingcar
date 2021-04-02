package car;

import car.domain.RacingCar;
import car.domain.RacingCars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @DisplayName("addCars는 moveCount가 0인 자동차를 carCount만큼 추가해야 한다.")
    @Test
    public void addCarsThenCarsWithMoveCountZeroMustBeAdded() {
        // Arrange
        RacingCars racingCars = new RacingCars();
        int carCount = 3;

        // Act
        racingCars.addCars(carCount);

        // Assert
        assertThat(racingCars.getRacingCars().size()).isEqualTo(3);
        racingCars.getRacingCars().forEach(it ->
                assertThat(it.getMoveCount()).isEqualTo(0)
        );
    }

    @DisplayName("runRound는 자동차들을 랜덤하게 이동시킨다.")
    @Test
    public void runRoundThenCarsMustMoveMoreThanZero() {
        // Arrange
        RacingCars racingCars = new RacingCars();

        // Act & Assert
        racingCars.runRound();
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            assertThat(racingCar.getMoveCount()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
        }
    }
}
