package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("이름이 부여된 자동차가 기존 기능을 정상적으로 수행하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    void moveOrStopNamedRacingCar(int randomNumber, int distance) {
        RacingCar namedRacingCar = new RacingCar("daham");

        namedRacingCar.moveOrStop(randomNumber);

        assertThat(namedRacingCar)
                .extracting("distance")
                .isEqualTo(distance);
    }

    @DisplayName("이름이 5자 초과를 한 자동차는 substring 수행")
    @Test
    void substringCarName() {
        RacingCar carNameSixLength = new RacingCar("wangta");

        assertThat(carNameSixLength)
                .extracting("carName")
                .isEqualTo("wangt");
    }

}
