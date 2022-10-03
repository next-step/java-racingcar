package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 이동할_수_있다() {
        Car car = new Car("pobi");
        int nowStatus = car.getStatus();

        car.move(() -> true);

        assertThat(car.getStatus()).isGreaterThan(nowStatus);
    }

    @Test
    void 정지한다() {
        Car car = new Car("pobi");
        int nowStatus = car.getStatus();

        car.move(() -> false);

        assertThat(car.getStatus()).isEqualTo(nowStatus);
    }

    @ParameterizedTest
    @ValueSource(strings = {"booooooo", "dfsfgfd", "csdffdgfdg"})
    @DisplayName("자동차 이름은 5글자를 초과할 수 없다.")
    void 이름이_5미만(String value) {
        assertThatThrownBy(() -> new Car(value))
                .isInstanceOf(RuntimeException.class);
    }
}
