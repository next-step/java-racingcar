package woowacamp.racingcar.domain;

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

    @ValueSource(ints = {4, 9})
    @ParameterizedTest
    void 숫자가_4이상이면_전진한다(int number) {
        Car car = new Car("충규");

        car.move(() -> number);

        assertThat(car.isEqualPosition(new Position(1)))
                .isTrue();
    }

    @ValueSource(ints = {0, 3})
    @ParameterizedTest
    void 숫자가_3이하면_전진하지_않는다(int number) {
        Car car = new Car("충규");

        car.move(() -> number);

        assertThat(car.isEqualPosition(new Position(0)))
                .isTrue();
    }
}
