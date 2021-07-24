package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceTest {
    RacingCar racingCar = new RacingCar();

    @Test
    @DisplayName("random value Test")
    void randomValueTest() {
        assertThat(racingCar.getRandomValue()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @ParameterizedTest
    @DisplayName("move Test")
    @CsvSource(value = {"9:true", "4:true", "1:false"}, delimiter = ':')
    void isMoveValueTest(int input, boolean expected) {
        assertEquals(racingCar.isMove(input), expected);
    }

}
