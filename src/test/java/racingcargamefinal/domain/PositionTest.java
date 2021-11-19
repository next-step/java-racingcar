package racingcargamefinal.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    private final Position position = new Position(3);

    @Test
    void create() {
        assertThat(position).isEqualTo(new Position(3));
        assertThat(Position.ZERO).isEqualTo(new Position(0));
    }

    @Test
    void createFail() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 음수일 수 없습니다.");
    }

    @Test
    void move() {
        assertThat(position.move()).isEqualTo(new Position(4));
    }

    @ParameterizedTest
    @MethodSource(value = "providePosition")
    void compareTo(Position other, int expected) {
        assertThat(position.compareTo(other)).isEqualTo(expected);
    }

    private static Stream<Arguments> providePosition() {
        return Stream.of(
                Arguments.of(new Position(2), 1),
                Arguments.of(new Position(3), 0),
                Arguments.of(new Position(4), -1)
        );
    }

}
