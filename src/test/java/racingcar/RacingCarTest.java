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

    @DisplayName("4이상, 3이하 CsvSource 어노테이션 사용하여 움직임 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void moveOrStopByRandomGenerator(int randomNumber, int distance) {
        racingCar.moveOrStop(randomNumber);

        assertThat(racingCar)
                .extracting("distance")
                .isEqualTo(distance);
    }

}
