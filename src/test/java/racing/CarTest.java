package racing;

import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void assertMoveCar() {
        Car car = new Car("SONNY");
        int TEST_NUMBER_LESS_THAN_FOUR = 3;
        int TEST_NUMBER_GREATER_THAN_FOUR = 5;

        car.moveCar();

        assertThat(car.getDistance()).isEqualTo(1);

        car.validateForMove(TEST_NUMBER_LESS_THAN_FOUR);
        assertThat(car.getDistance()).isEqualTo(1);

        car.validateForMove(TEST_NUMBER_GREATER_THAN_FOUR);
        assertThat(car.getDistance()).isEqualTo(2);
    }

    @Test
    void assertCarNameLength() {
        assertThatThrownBy(() -> {
            Car car = new Car("SONNYYYYYY");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자를 초과할 수 없습니다.");
    }
}