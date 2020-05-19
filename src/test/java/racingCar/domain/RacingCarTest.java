package racingCar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void initRacingCarPosition() {
        RacingCar racingCar = new RacingCar("lion", 0);
        int position = racingCar.getPosition();
        assertThat(position).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"true,1","false,0"})
    void move(boolean isMove, int expected) {
        // Given
        RacingCar racingCar = new RacingCar("lion", 0);

        // When
        racingCar.move(isMove);

        //Then
        assertThat(racingCar.getPosition()).isEqualTo(expected);
    }

    @Test
    void compareTo() {
        // Given
        RacingCar racingCar = new RacingCar("lion", 4);
        RacingCar compareRacingCar = new RacingCar("cat", 2);

        // When
        int result = racingCar.compareTo(compareRacingCar);

        // Then
        assertThat(result).isEqualTo(-1);
    }
}
