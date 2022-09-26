package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("4, 5, 6, 7, 8, 9이면 전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진하는_경우_테스트(int movable) {
        Car car = new Car();
        car.move(movable);

        assertThat(car.getMoved()).isEqualTo("-");
    }

    @DisplayName("0, 1, 2, 3이면 제자리")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 제자리에_있는_테스트(int movable) {
        Car car = new Car();
        car.move(movable);

        assertThat(car.getMoved()).isEqualTo("");
    }

}