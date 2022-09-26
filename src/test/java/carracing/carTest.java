package carracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class carTest {
    @Test
    void 자동차_처음위치는_1() {
        Car car = new Car();
        car.move(0);
        assertThat(car.trail()).isEqualTo("-");
    }

    @Test
    void 자동차는_이동이_가능하다() {
        Car car = new Car();
        car.move(2);
        assertThat(car.trail()).isEqualTo("---");
    }

    @Test
    void 자동차는_양수이동만_가능하다() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.move(-1);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 자동차는_임계점이하_가능하다() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.move(5);
        }).isInstanceOf(RuntimeException.class);
    }
}
