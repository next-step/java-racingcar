package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @Test
    void 자동차이름_5자초과() {
        Exception e = assertThrows(Exception.class, () -> new Car("abcdef"));
        assertThat(e.getMessage()).isEqualTo("자동차 이름 길이 초과 (최대 5자)");
    }

    @Test
    void 자동차_move() throws Exception {
        Car car = new Car("abc");
        car.move(1);
        assertThat(car.getLocation()).isEqualTo(1);
    }

}
