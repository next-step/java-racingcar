package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setup() {
        car = new Car("pobi");
    }

    @Test
    void 이동() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 정지() {
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
