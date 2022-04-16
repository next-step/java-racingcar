package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    @Test
    void carNamesGiven_ReturnCars() {
        String[] carNames = {"car", "car2"};
        assertThat(new RacingCars(carNames).getCars().size()).isEqualTo(carNames.length);
    }
}
