package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racinggame.domain.value.Position;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.fixture.CarFixture.CAR1;

class CarTest {

    @DisplayName("moveValue에 따른 자동차 전진상태 확인")
    @ParameterizedTest
    @MethodSource("provideMoveValue")
    void move(int moveValue1, int moveValue2, int moveValue3, int expected) {
        CAR1.move(moveValue1);
        CAR1.move(moveValue2);
        CAR1.move(moveValue3);

        Position position = Position.of(expected);
        assertThat(CAR1.position()).isEqualTo(position.current());
    }

    private static Stream<Arguments> provideMoveValue() {
        return Stream.of(
                Arguments.of(2, 5, 7, 2));
    }
}