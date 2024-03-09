package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @DisplayName("")
    void testMove(int strategyReturn) {
        Car car = new Car(() -> strategyReturn);

        car.move();

        assertThat(car.position()).isEqualTo(strategyReturn);
    }
}