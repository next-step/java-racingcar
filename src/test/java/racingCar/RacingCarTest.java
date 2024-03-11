package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {

    private final MoveStrategy strategy = new MoveStrategy();
    private RacingCar car;

    @BeforeEach
    void init() {
        car = new RacingCar(strategy);
    }

    @Test
    void 생성된_RacingCar의_초기위치는_0() {
        assertThat(car.findCurrentLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 한대의_RacingCar_이동_성공(int input) {
        car.move(input);
        assertThat(car.findCurrentLocation()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 한대의_RacingCar_이동_실패(int input) {
        car.move(input);
        assertThat(car.findCurrentLocation()).isEqualTo(0);
    }
}
