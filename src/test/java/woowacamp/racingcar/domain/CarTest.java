package woowacamp.racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarTest {
    @ValueSource(strings = {"충", "충규충규충"})
    @ParameterizedTest
    void 자동차를_생성한다(String name) {
        assertDoesNotThrow(() -> new Car(name));
    }

    @Test
    void 자동차를_움직인다() {
        Car car = new Car("충규");

        car.move(() -> 1);

        assertThat(car.isEqualPosition(new Position(1)))
                .isTrue();
    }
}
