package racingcarwinner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcarwinner.Exception.IllegalNameSizeException;
import racingcarwinner.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("테스트1");
    }

    @Test
    void 자동차_움직임_전진조건() {
        car.move(() -> true);
        assertThat(car.getPositionNumber()).isEqualTo(1);
    }

    @Test
    void 자동차_움직임_멈춤조건() {
        car.move(() -> false);
        assertThat(car.getPositionNumber()).isEqualTo(0);
    }

    @Test
    void 자동차이름_5글자초과_예외발생() {
        assertThatThrownBy(() -> {
            Car car = new Car("abcdefg");
        }).isInstanceOf(IllegalNameSizeException.class);

    }
}
