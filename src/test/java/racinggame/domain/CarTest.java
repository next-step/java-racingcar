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

    @DisplayName("랜덤 넘버가 4 이상이면 자동차는 전진한다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void 자동차_이동(final int number) {
        Car testCar = Car.of("test");
        testCar.moveForward(number);
        Assertions.assertThat(testCar.getLocation()).isEqualTo(1);
    }

    @DisplayName("랜덤 넘버가 4 미만이면 자동차는 정지한다")
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void 자동차_정지(final int number) {
        Car testCar = Car.of("test");
        testCar.moveForward(number);
        Assertions.assertThat(testCar.getLocation()).isEqualTo(0);
    }
}