package racinggame.domain;

import org.assertj.core.api.Assertions;
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
        Assertions.assertThat(actual).isEqualTo(name);
    }

    @DisplayName("자동차 이름은 5자를 넘을 수 없다")
    @ValueSource(strings = {"123456", "가나다라마바사", "abcdef"})
    @ParameterizedTest
    void 자동차_이름_체크(final String name) {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> Car.of(name));
    }

    @DisplayName("자동차가 전진하는지 확인")
    @Test
    void 자동차_이동() {
        Car testCar1 = Car.of("test1");
        Car testCar2 = Car.of("test2");
        testCar1.moveForward();
        Assertions.assertThat(testCar1.getLocation()).isEqualTo(1);
        Assertions.assertThat(testCar2.getLocation()).isEqualTo(0);
    }
}