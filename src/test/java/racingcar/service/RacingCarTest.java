package racingcar.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.service.RacingCar.go;

public class RacingCarTest {
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void 전진(int number) {
        assertThat(go(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void 멈춤(int number) {
        assertThat(go(number)).isFalse();
    }
}
