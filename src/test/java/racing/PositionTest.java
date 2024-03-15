package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Position;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2", "1:3", "2:3", "2:4", "3:5"}, delimiter = ':')
    void add(int startPosition, int addPosition) {
        Position position = Position.valueOf(startPosition);
        assertThat(position.add(addPosition)).isEqualTo(Position.valueOf(startPosition + addPosition));
    }

    @Test
    @DisplayName("max 호출 시 정수 파라미터와 비교하여 높은 값을 반환")
    void max() {
        Position position = Position.valueOf(2);

        assertThat(position.max(3)).isEqualTo(3);
        assertThat(position.max(2)).isEqualTo(2);
        assertThat(position.max(1)).isEqualTo(2);
    }
}