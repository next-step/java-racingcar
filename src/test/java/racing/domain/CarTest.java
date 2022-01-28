package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름_길이_확인() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car("abcdef"));
    }

    @Test
    void 자동차_이름_출력_확인() {
        Car car1 = new Car("abc");
        assertThat(car1.getNameBy(0)).isEqualTo("abc");
        assertThat(car1.getNameBy(2)).isEmpty();
    }

    @Test
    void 자동차_움직임_여부() {
        Car car = new Car("abc");
        car.drive(3);
        assertThat(car.getPosition()).isEqualTo(0);
        car.drive(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}