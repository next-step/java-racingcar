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

    private RacingCar car;

    @BeforeEach
    void init() {
        car = new RacingCar();
    }

    @Test
    void 생성된_RacingCar의_초기위치는_0() {
        assertThat(car.findCurrentLocation()).isEqualTo(0);
    }

    @Test
    void 한대의_RacingCar_이동_성공() {
        car.move(true);
        assertThat(car.findCurrentLocation()).isEqualTo(1);
    }

    @Test
    void 한대의_RacingCar_이동_실패() {
        car.move(false);
        assertThat(car.findCurrentLocation()).isEqualTo(0);
    }

    @Test
    void 여러대의_RacingCar_이동_성공() {
        List<RacingCar> cars = Arrays.asList(new RacingCar(), new RacingCar());
        cars.forEach(car -> {
            car.move(true);
            assertThat(car.findCurrentLocation()).isEqualTo(1);
        });
    }

    @Test
    void 여러대의_RacingCar_이동_실패(int input) {
        List<RacingCar> cars = Arrays.asList(new RacingCar(), new RacingCar());
        cars.forEach(car -> {
            car.move(false);
            assertThat(car.findCurrentLocation()).isEqualTo(0);
        });
    }


    @Test
    void 현재Location_만큼_hyphen_Return() {
        car.move(true);
        car.move(true);
        car.move(true);
        assertThat(car.toString()).isEqualTo("---");
    }
}
