package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    private static final int CONDITION_FOR_NAME_LENGTH = 5;

    @Test
    void assertMoveCar() {
        Car car = new Car("SONNY");
        int testNumberLessThanFour = 3;
        int testNumberGreaterThanFour = 5;

        car.moveCar();

        assertThat(car.distance().value()).isEqualTo(1);

        car.validateForMove(testNumberLessThanFour);
        assertThat(car.distance().value()).isEqualTo(1);

        car.validateForMove(testNumberGreaterThanFour);
        assertThat(car.distance().value()).isEqualTo(2);
    }

    @Test
    void assertCarNameLength() {
        String errorMessage = String.format("자동차 이름은 %s글자를 초과할 수 없습니다.", CONDITION_FOR_NAME_LENGTH);
        assertThatThrownBy(() -> {
            Car car = new Car("SONNYYYYYY");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @Test
    void assertIsThisWinningWithAlone() {
        Car car = new Car("SONNY", 3);

        assertThat(car.isThisWinningAlone(2)).isTrue();
    }

    @Test
    void assertIsThisWinningWithOthers() {
        Car car = new Car("SONNY", 2);

        assertThat(car.isThisWinningWithOthers(2)).isTrue();
    }

    @Test
    void assertPresentHigherDistance() {
        Car car = new Car("SONNY", 3);

        assertThat(car.presentHigherDistance(1)).isEqualTo(3);
    }
}