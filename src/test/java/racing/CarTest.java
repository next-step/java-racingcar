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

    @Test
    void assertIsThisWinningWithAlone() {
        Car car = new Car("SONNY", 3);

        assertThat(car.isThisWinningAlone(2)).isEqualTo(true);
    }

    @Test
    void assertIsThisWinningWithOthers() {
        Car car = new Car("SONNY", 2);

        assertThat(car.isThisWinningWithOthers(2)).isEqualTo(true);
    }

    @Test
    void assertPresentHigherDistance() {
        Car car = new Car("SONNY", 3);

        assertThat(car.presentHigherDistance(1)).isEqualTo(3);
    }
}