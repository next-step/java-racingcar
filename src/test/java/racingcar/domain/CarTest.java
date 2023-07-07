package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarTest {
    @ValueSource(strings = {"충", "충규충규충"})
    @ParameterizedTest
    @DisplayName("자동차를 생성한다.")
    void test_01(String name) {
        /* given */

        /* when & then */
        assertDoesNotThrow(() -> new Car(name));
    }

    @Test
    @DisplayName("자동차를 움직인다.")
    void test_02() {
        /* given */
        final Car car = new Car("충규");

        /* when */
        car.move(() -> 7);

        /* then */
        assertThat(car.getPosition()).isEqualTo(new Position(7));
    }
}
