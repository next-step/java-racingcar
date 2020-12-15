package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
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
}
