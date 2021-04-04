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
        String[] carNames = new String[] {"Cactus", "Alpha", "April"};

        // Act
        racingCars.addCars(carNames);

        // Assert
        assertThat(racingCars.getRacingCars().size()).isEqualTo(3);
        racingCars.getRacingCars().forEach(it ->
                assertThat(it.getMoveCount()).isEqualTo(0)
        );
    }

    @DisplayName("addCars는 carNames의 이름을 가진 RacingCar을 그 순서대로 추가해야 한다.")
    @Test
    public void addCarsThenCarsWithCarNamesMustBeAddedWithSameOrder() {
        // Arrange
        RacingCars racingCars = new RacingCars();
        String[] carNames = new String[] {"Proverbs", "Calling", "Oswald"};

        // Act
        racingCars.addCars(carNames);
        for(int i = 0; i < carNames.length; ++i) {
            assertThat(racingCars.getRacingCars().get(i).getCarName()).isEqualTo(carNames[i]);
        }
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
