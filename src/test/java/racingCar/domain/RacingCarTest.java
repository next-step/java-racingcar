package racingCar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void move() {
        // Given
        RacingCar racingCar = new RacingCar(1);

        // When
        racingCar.move(3);
        racingCar.move(9);
        racingCar.move(1);
        racingCar.move(6);
        racingCar.move(4);

        //Then
        assertThat(racingCar.getPosition()).isEqualTo(4);
    }
}
