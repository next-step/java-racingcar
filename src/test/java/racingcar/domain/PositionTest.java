package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PositionTest {

    @DisplayName("생성 확인")
    @Test
    void createPosition() {
        assertDoesNotThrow(() -> new Position(1));
    }

    @DisplayName("음수 입력 시 예외 발생")
    @Test
    void whenCreatingWithNegativePositionThenThrowsException() {
        assertThatThrownBy(() -> new Car("a", -1)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Position 끼리 덧셈 연산")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "2,3", "3,4"})
    void add(int position, int expected) {
        Position newPosition = new Position(1).add(new Position(position));

        assertThat(newPosition).isEqualTo(new Position(expected));
    }

    @DisplayName("Position 리스트 중 가장 큰 값을 찾기")
    @Test
    void findMax() {
        List<Position> positions = List.of(new Position(1), new Position(10), new Position(100));

        Optional<Position> max = positions.stream()
                .max((p1, p2) -> p1.compare(p1, p2));

        assertThat(max).contains(new Position(100));
    }
}
