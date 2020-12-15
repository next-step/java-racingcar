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
        car.move(input);
        assertThat(car.getDistance()).isEqualTo(expected);
    }
}
