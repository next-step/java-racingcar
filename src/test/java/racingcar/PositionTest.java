package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("위치는 move() 호출 시 1칸 증가한다")
    @Test
    void positionMove() {
        assertThat(new Position(0).move()).isEqualTo(new Position(1));
    }

    @DisplayName("값이 음수일 경우 예외가 발생한다")
    @Test
    void negativeInputThrowsException() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수");
    }

    @DisplayName("더 큰 값을 반환한다")
    @ParameterizedTest
    @CsvSource({
            "3, 5, 5",
            "5, 3, 5",
            "4, 4, 4",
            "0, 0, 0",
            "0, 1, 1",
            "1, 0, 1"
    })
    void max_returnsCorrectPosition(int thisValue, int otherValue, int expectedValue) {
        Position thisPosition = new Position(thisValue);
        Position otherPosition = new Position(otherValue);
        assertThat(thisPosition.max(otherPosition)).isEqualTo(new Position(expectedValue));
    }
}