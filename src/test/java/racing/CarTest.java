package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class CarTest {

    class Car {
        private int step = 0;

        public int forward(int step) {
            this.step += step;
            return this.step;
        }
    }

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName(value = "전진 테스트")
    void forwards() {
        assertThat(car.forward(0)).isEqualTo(0);
        assertThat(car.forward(1)).isEqualTo(1);
        assertThat(car.forward(10)).isEqualTo(11);
    }
}