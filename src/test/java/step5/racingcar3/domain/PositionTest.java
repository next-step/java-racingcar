package step5.racingcar3.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.racingcar3.exception.PositionException;

public class PositionTest {

    @Test
    @DisplayName("양수로 만들면 성공")
    void givenPositiveNumber_whenCreatePosition_thenSuccess() {
        // given
        // when
        // then
        assertDoesNotThrow(() -> new Position(1));
        assertThat(new Position(1).value()).isEqualTo(1);
    }

    @Test
    @DisplayName("0으로 만들면 성공")
    void givenZero_whenCreatePosition_thenSuccess() {
        // given
        // when
        // then
        assertDoesNotThrow(() -> new Position(0));
        assertThat(new Position(0).value()).isEqualTo(0);
    }

    @Test
    @DisplayName("음수로 만들면 실패")
    void givenNegativeNumber_whenCreatePosition_thenFail() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Position(-1)).isExactlyInstanceOf(PositionException.class);
    }

}
