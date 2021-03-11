package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.move.MoveStrategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.util.Constants.START_IDX;

/**
 * 자동차 생성, 이동 테스트
 */
class CarTest {

    // 자동차 생성 시 움직임 전략을 설정
    private MoveStrategy getMoveStrategy(boolean flag) {
        return () -> flag;
    }

    private static Stream<Arguments> carList() {
        return Stream.of(
            Arguments.of("a", "a"),
            Arguments.of("b", "b")
        );
    }

    private static Stream<Arguments> carPosition() {
        return Stream.of(
            Arguments.of("a", true, 1),
            Arguments.of("b", false, 0)
        );
    }
    @DisplayName("자동차 생성 테스트")
    @ParameterizedTest(name = "자동차 이름부여 생성 테스트 {0} == {1}")
    @MethodSource(value = "carList")
    void createdCar_ShouldNotNull(String name, String expected) {
        // given
        Car car = new Car(name);
        // when

        // then
        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo(expected);
    }

    @DisplayName("자동차의 이동하는지 확인하는 테스트")
    @ParameterizedTest(name = "이동 여부 : {0} 설정 시 -> position 값 : {1}")
    @MethodSource(value = "carPosition")
    void move_CarPosition(String name, boolean flag, int position) {
        // given
        Car car = new Car(name, getMoveStrategy(flag));
        // when
        car.move();
        // then
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("자동차의 연속적인 이동 위치를 확인 테스트")
    @ParameterizedTest(name = "자동차 이동 전략: {0}, position 값 : {1}")
    @CsvSource(value = {"true, 2", "false, 0"})
    void moves_CarPosition(boolean firstFlag, int position) {
        // given
        Car car = new Car("name", getMoveStrategy(firstFlag));
        // when
        car.move();
        car.move();
        // then
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
