package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CarTest {
    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("자동차는 주사위의 값이 MOVE_THRESHOLD값의 이상일 때만 전진한다.")
    void moveOnceTest(int diceValue, boolean expected) {
        // given
        var car = new Car("");

        // when
        car.move(diceValue);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(expected ? 1 : 0);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(Car.MOVE_THRESHOLD-1, false),
                Arguments.of(Car.MOVE_THRESHOLD, true),
                Arguments.of(Car.MOVE_THRESHOLD+1, true)
        );
    }

    @Test
    @DisplayName("자동차의 이름을 받아 생성한다.")
    void createCarWithNameTest() {
        // given
        var name = "pobi";

        // when
        var car = new Car(name);

        // then
        Assertions.assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차의 이름은 5자를 초과 할 수 없다.")
    void createCarWithLongNameTest() {
        // given
        var name = "123456";

        // when & then
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
