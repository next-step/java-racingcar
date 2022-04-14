package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.service.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar(1, 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진조건_4이상_9이하(int number) {
        assertThat(racingCar.moveCondition(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 정지조건_0이상_4미만(int number) {
        assertThat(racingCar.moveCondition(number)).isFalse();
    }

    @Test
    void 랜덤값_범위검증() {
        assertThat(racingCar.getRandomNumber()).isGreaterThanOrEqualTo(0);
        assertThat(racingCar.getRandomNumber()).isLessThanOrEqualTo(9);
    }

}
