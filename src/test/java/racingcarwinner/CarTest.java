package racingcarwinner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcarwinner.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("테스트1");
    }

    @Test
    void 자동차_생성() {
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void 자동차위치_초기() {
        assertThat(car.getPosition()).isEqualTo("");
    }

    @Test
    void 자동차_움직임_전진조건() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo("-");
    }

    @Test
    void 자동차_움직임_멈춤조건() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo("");
    }
}
