package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private static Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차는 랜덤값이 4이상이면 이동할 수 있다.")
    void move_O() {
        // when
        car.move(4);
        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 랜덤값이 4미만이면 이동할 수 없다.")
    void move_X() {
        // when
        car.move(3);
        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
