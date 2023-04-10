package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 10, 11})
    void 주어진_랜덤값이_0보다작거나_9보다크면_IllegalArgumentException이_발생한다(int input) {
        assertThatThrownBy(() -> racingCar.goOrStop(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("잘못된 입력입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 주어진_랜덤값이_4이상_9이하일경우_움직인다(int input) {
        racingCar.goOrStop(input);
        assertThat(racingCar.getPosition())
            .isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 주어진_랜덤값이_4미만일경ㅇ_멈춘다(int input) {
        racingCar.goOrStop(input);
        assertThat(racingCar.getPosition())
            .isEqualTo(0);
    }
}
