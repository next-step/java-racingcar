package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Car;

import static org.assertj.core.api.Assertions.*;
import static step3.domain.Car.NAME_LENGTH_EXCEPTION_MESSAGE;
import static step3.domain.Car.NO_ROUND_EXCEPTION_MESSAGE;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @DisplayName("움직임 여부를 받아 움직이면, 움직인 거리가 +1 된다. 움직이지 않은 경우는 움직인 거리는 그대로 유지된다.")
    @ParameterizedTest
    @CsvSource({"true,1", "false,0"})
    void move(boolean input, int expected) {
        car.move(1, input);

        assertThat(car.getDistance()).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차가 한번 움직일 경우, roundHistory 정보가 하나 늘어나냐 한다.")
    void move_roundHistory() {
        assertThat(car.getRoundHistory().size()).isEqualTo(0);

        car.move(1, true);

        assertThat(car.getRoundHistory().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("원하는 라운드를 입력하면 해당 라운드의 거리를 반환한다. 경기하지 않은 Round가 입력될 경우 Exception을 반환한다.")
    void getDistanceByRound() {
        car.move(1, true);
        car.move(2, true);
        car.move(3, false);

        assertThat(car.getDistanceByRound(3)).isEqualTo(2);
        assertThatIllegalStateException().isThrownBy(() -> {
            car.getDistanceByRound(4);
        }).withMessage(NO_ROUND_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("자동차의 이름은 5자를 초과할 수 없다.")
    void assertName() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("yeoseon");
        }).withMessage(NAME_LENGTH_EXCEPTION_MESSAGE);
    }
}
