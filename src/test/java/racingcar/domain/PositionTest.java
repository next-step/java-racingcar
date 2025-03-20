package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    @DisplayName("Position이 0 이상이면 정상적으로 Position을 생성한다")
    void createSuccess(int initPosition) {
        assertDoesNotThrow(() -> Position.of(initPosition));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5})
    @DisplayName("Position이 0보다 작은 값을 가질 수 없다")
    void createFail(int initPosition) {
        Assertions.assertThatThrownBy(() -> Position.of(initPosition))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0:1", "0:1:-1", "0:0:0"}, delimiter = ':')
    @DisplayName("더 크면 1 더 작으면 -1 같으면 0을 반환해야 한다")
    void compareTo(int src, int dest, int expected) {
        int actual = Position.of(src).compareTo(Position.of(dest));
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Position을 더하면 1을 더한 새로운 Position 객체를 가져야 한다")
    void plus() {
        Position position = Position.of(1);
        Position newPosition = position.plus();
        Assertions.assertThat(newPosition).isEqualTo(Position.of(2));
    }

    @Test
    @DisplayName("Position 값이 같으면 같은 포지션이다.")
    void testEquals() {
        Position position1 = Position.of(1);
        Position position2 = Position.of(1);
        Assertions.assertThat(position1).isEqualTo(position2);
    }

    @Test
    @DisplayName("Position 값이 같으면 같은 hashCode를 가져야 한다.")
    void testHashCode() {
        Position position1 = Position.of(1);
        Position position2 = Position.of(1);
        Assertions.assertThat(position1.hashCode()).isEqualTo(position2.hashCode());
    }
}
