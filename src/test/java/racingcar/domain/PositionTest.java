package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    private static final int TEN = 10;
    private static final int HUNDRED = 100;

    @DisplayName("생성자에 음수 전달하면 예외")
    @Test
    void validation() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        // given
        int startPosition = 5;
        int moveCount = 3;
        Position position = new Position(startPosition);

        // when
        for (int i = 0; i < moveCount; i++) {
            position = position.move();
        }

        // then
        assertThat(position).isEqualTo(new Position(startPosition + moveCount));
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForEquals")
    void equals(Position position, Position anotherPosition, boolean expected) {
        assertThat(position.equals(anotherPosition)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForCompareTo")
    void compareTo(Position position, Position anotherPosition, int expected) {
        assertThat(position.compareTo(anotherPosition)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgumentsForEquals() {
        return Stream.of(
                Arguments.of(new Position(), new Position(), true),
                Arguments.of(new Position(TEN), new Position(TEN), true),
                Arguments.of(new Position(TEN), new Position(HUNDRED), false)
        );
    }

    private static Stream<Arguments> provideArgumentsForCompareTo() {
        final int SAME = 0;
        final int GREATER = 1;
        final int SMALLER = -1;

        return Stream.of(
                Arguments.of(new Position(), new Position(), SAME),
                Arguments.of(new Position(TEN), new Position(TEN), SAME),
                Arguments.of(new Position(HUNDRED), new Position(TEN), GREATER),
                Arguments.of(new Position(TEN), new Position(HUNDRED), SMALLER)
        );
    }
}