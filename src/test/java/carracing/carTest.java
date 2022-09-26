package carracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class carTest {
    @Test
    void 자동차_처음위치는_0() {
        Car car = new Car();
        assertThat(car.trail()).isEqualTo("");
    }

    @Test
    void 자동차는_임계점미만이면_이동하지_않는다() {
        Car car = new Car();
        car.move(2);
        assertThat(car.trail()).isEqualTo("");
    }

    @Test
    void 자동차는_임계점이상이면_이동한다() {
        Car car = new Car();
        car.move(5);
        assertThat(car.trail()).isEqualTo("-");
    }

    @Test
    void 자동차는_0부터9까지의_랜덤값만_입력_가능하다() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.move(11);
        }).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> {
            car.move(-2);
        }).isInstanceOf(RuntimeException.class);
    }

}
