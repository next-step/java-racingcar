package racing;

import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void assertMoveCar() {
        Car car = new Car("SONNY");
        int TestNumberLessThanFour = 3;
        int TestNumberGreaterThanFour = 5;

        car.moveCar();

        assertThat(car.distance()).isEqualTo(1);

        car.validateForMove(TestNumberLessThanFour);
        assertThat(car.distance()).isEqualTo(1);

        car.validateForMove(TestNumberGreaterThanFour);
        assertThat(car.distance()).isEqualTo(2);
    }

    @Test
    void assertCarNameLength() {
        assertThatThrownBy(() -> {
            Car car = new Car("SONNYYYYYY");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자를 초과할 수 없습니다.");
    }
}