package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void test_car_initial_state() {
        Car car = new Car();
        assertThat(car.getMoves()).isEqualTo(0);
    }

    @ParameterizedTest(name = "test_car_moving [{0}]")
    @ValueSource(ints = {1, 3})
    void test_car_moving(int moves) {
        Car car = new Car();
        for (int i = 0; i < moves; i++) {
            car.move();
        }
        assertThat(car.getMoves()).isEqualTo(moves);
    }
}
