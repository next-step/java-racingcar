package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @DisplayName("자동차는 5자 이하의 이름을 갖는다")
    @ValueSource(strings = {"123", "가나다", "abc"})
    @ParameterizedTest
    void 자동차_이름_생성(final String name) {
        Car car = Car.of(name);
        final String actual = car.getName();
        assertThat(actual).isEqualTo(name);
    }

    @DisplayName("자동차 이름은 5자를 넘을 수 없다")
    @ValueSource(strings = {"123456", "가나다라마바사", "abcdef"})
    @ParameterizedTest
    void 자동차_이름_체크(final String name) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Car.of(name));
    }

    @DisplayName("자동차의 기본 위치는 0이다")
    @Test
    void 자동차_기본_위치() {
        Car car = new Car("test");
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @DisplayName("자동차 이름는 1씩 전진할 수 있다")
    @Test
    void 자동차_이동() {
        Car car = new Car("test");
        car.moveForward();
        assertThat(car.getLocation()).isEqualTo(1);
    }
}