package racing.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.test.TestCarForwardBehavior;
import racing.domain.test.TestCarStopBehavior;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @DisplayName("Car 전진")
    @ValueSource(ints = 1)
    void moveTest(int expected) {
        Car car = new Car("car");
        assertThat(car.move(new TestCarForwardBehavior())).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("Car 정지")
    @ValueSource(ints = 0)
    void stopTest(int expected) {
        Car car = new Car("car");
        assertThat(car.move(new TestCarStopBehavior())).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 없을 때")
    @EmptySource
    void checkCarNameNullTest(String input) {
        assertThatThrownBy(() -> Car.checkCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 비어있습니다. 이름을 모두 입력해주세요.");
    }
}
