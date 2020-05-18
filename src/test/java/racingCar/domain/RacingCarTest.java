package racingCar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void initRacingCarPosition() {
        RacingCar racingCar = new RacingCar();
        int position = racingCar.getPosition();
        assertThat(position).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"true,1","false,0"})
    void move(boolean isMove, int expected) {
        // Given
        RacingCar racingCar = new RacingCar();

        // When
        racingCar.move(isMove);

        //Then
        assertThat(racingCar.getPosition()).isEqualTo(expected);
    }
}
