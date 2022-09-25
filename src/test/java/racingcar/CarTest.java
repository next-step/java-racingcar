package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Car;
import racingcar.domain.movingcondition.MovingCondition;

class CarTest {

    @ParameterizedTest(name = "조건에 따른 차 움직임 테스트: {2}")
    @MethodSource("provideMovingCondition")
    void moveTest(MovingCondition condition, int expectedPosition) {
        assertThat(new Car().move(condition)).isEqualTo(expectedPosition);
    }

    @ParameterizedTest(name = "움직임 횟수에 따른 이동 거리 테스트: {0}회")
    @ValueSource(ints = {1, 2, 3, 4, 10})
    void positionTest(int moveCount) {
        Car car = new Car();
        int position = 0;

        for (int i = 0; i < moveCount; ++i) {
            position = car.move(() -> true);
        }

        assertThat(position).isEqualTo(moveCount);
    }

    private static Stream<Arguments> provideMovingCondition() {
        return Stream.of(
            Arguments.of((MovingCondition)() -> true, 1, "움직일 수 있는 경우"),
            Arguments.of((MovingCondition)() -> false, 0, "움직일 수 없는 경우")
        );
    }
}
