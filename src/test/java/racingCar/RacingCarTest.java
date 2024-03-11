package racingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
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

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 여러대의_RacingCar_이동_성공(int input) {
        List<RacingCar> cars = Arrays.asList(new RacingCar(strategy), new RacingCar(strategy));
        cars.forEach(car -> {
            car.move(input);
            assertThat(car.findCurrentLocation()).isEqualTo(1);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 여러대의_RacingCar_이동_실패(int input) {
        List<RacingCar> cars = Arrays.asList(new RacingCar(strategy), new RacingCar(strategy));
        cars.forEach(car -> {
            car.move(input);
            assertThat(car.findCurrentLocation()).isEqualTo(0);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, 10, 11, 12})
    void 입력값이_0미만10이상일때_Error(int input) {
        assertThatThrownBy(() -> car.move(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 현재Location_만큼_hyphen_Return() {
        car.move(7);
        car.move(8);
        car.move(9);
        assertThat(car.toResult()).isEqualTo("---");
    }
}
