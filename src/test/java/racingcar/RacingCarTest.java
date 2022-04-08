package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @DisplayName("CsvSource 어노테이션 사용하여 움직임 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    void moveOrStopByRandomGenerator(int randomNumber, int distance) {
        racingCar.moveOrStop(randomNumber);

        assertThat(racingCar)
                .extracting("distance")
                .isEqualTo(distance);
    }

}
