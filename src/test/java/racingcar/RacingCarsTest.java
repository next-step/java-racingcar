package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    @Test
    void carNamesGiven_ReturnCars() {
        String[] carNames = {"car", "car2"};
        assertThat(new RacingCars(carNames).getCars().size()).isEqualTo(carNames.length);
    }

    @Test
    void carsGiven_ReturnWinners() {
        RacingCars racingCars = new RacingCars(new String[]{"car1", "car2", "car3"});
        for (int attempt=0; attempt < 3; attempt++) {
            racingCars.turnAroundCircuit();
        }
        assertThat(racingCars.award().length()).isGreaterThan(4);
    }
}
