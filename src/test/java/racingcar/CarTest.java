package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

public class CarTest {

    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void 전진_불가(final int condition) {
        Car car = new Car("leah");
        car.moveForward(condition);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void 전진_가능(final int condition) {
        Car car = new Car("leah");
        car.moveForward(condition);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ValueSource(strings = {"LeahJiin", "Samuel", "JiinLee"})
    @ParameterizedTest
    void 자동차의_이름이_5글자_넘으면_예외_발생(final String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car(name));
    }

}
