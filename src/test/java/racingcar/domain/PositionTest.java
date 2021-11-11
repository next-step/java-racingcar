package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.PositionException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @ParameterizedTest
    @DisplayName("Position 생성 성공 테스트")
    @MethodSource
    void createPosition(int value, Position expected) {
        assertThat(Position.from(value)).isEqualTo(expected);
    }

    static Stream<Arguments> createPosition() {
        return Stream.of(
                Arguments.of(
                        1, Position.from(1)
                ),
                Arguments.of(
                        2, Position.from(2)
                ),
                Arguments.of(
                        2, Position.from(2)
                )
        );
    }

    @Test
    @DisplayName("초기 Position 생성 테스트")
    void positionInit() {
        Position init = Position.init();

        assertThat(init).isEqualTo(Position.from(0));
    }

    @ParameterizedTest
    @DisplayName("Position 생성 실패 테스트")
    @ValueSource(ints = {-1, -2, -3})
    void positionException(int value) {
        assertThatThrownBy(() -> Position.from(value)).isInstanceOf(PositionException.class);
    }

    @ParameterizedTest
    @DisplayName("Position move 테스트")
    @MethodSource
    void positionMove(Position position, int moveValue, Position expected) {
        position.move(moveValue);

        assertThat(position).isEqualTo(expected);
    }

    static Stream<Arguments> positionMove() {
        return Stream.of(
                Arguments.of(
                        Position.from(0), 1, Position.from(1)
                ),
                Arguments.of(
                        Position.from(1), 2, Position.from(3)
                ),
                Arguments.of(
                        Position.from(2), 3, Position.from(5)
                )
        );
    }
}