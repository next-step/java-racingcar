package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Car car;

    @BeforeEach
    void init() {
        car = new SimpleCar();
    }

    @Test
    @DisplayName("최초 포지션은 0")
    void Test_initial_position_0() {
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
