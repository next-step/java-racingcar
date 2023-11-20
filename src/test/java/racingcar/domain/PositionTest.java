package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.Position.POSITION_CANNOT_BE_NEGATIVE_NUMBER_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {

    @ParameterizedTest
    @DisplayName("포지션이 양수인지 검증한다.")
    @ValueSource(longs = {-1, -2, -126})
    void validate_position_that_is_positive_number(long given) {
        // when // then
        assertThatThrownBy(() -> new Position(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(POSITION_CANNOT_BE_NEGATIVE_NUMBER_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("움직이면 포지션이 1칸 앞으로 이동한다.")
    @CsvSource(value = {"1, 2", "0, 1", "15, 16"})
    void move(long given, long expected) {
        // given
        Position position = new Position(given);

        // when
        Position result = position.move();

        // then
        assertThat(result).isEqualTo(new Position(expected));
    }
}
