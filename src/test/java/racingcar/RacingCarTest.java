package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @DisplayName("경주용 차 난수가 4이상일 경우 전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveRacingCarIfRandomNumberIsFourOrMore(int randomNumber) {
        racingCar.moveOrStop(randomNumber);

        assertThat(racingCar)
                .extracting("distance")
                .isEqualTo(1);
    }

    @DisplayName("경주용 차 난수가 3이하일 경우 멈춤")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void stopRacingCarIfRandomNumberIsThreeOrLess(int randomNumber) {
        racingCar.moveOrStop(randomNumber);

        assertThat(racingCar)
                .extracting("distance")
                .isEqualTo(0);
    }
}
