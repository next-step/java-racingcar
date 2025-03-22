package step5.racingcar3.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.racingcar3.exception.PositiveNumberException;

public class PositiveNumberTest {

    @Test
    @DisplayName("음의 정수면 실패")
    void givenNegativeNumber_whenCreatePositiveNumber_thenFail() {
        // given
        // when
        assertThatThrownBy(() -> new PositiveNumber(-1))

            // then
            .isExactlyInstanceOf(PositiveNumberException.class);
    }

    @Test
    @DisplayName("0 도 실패")
    void givenZero_whenCreatePositiveNumber_thenFail() {
        // given
        // when
        assertThatThrownBy(() -> new PositiveNumber(0))

            // then
            .isExactlyInstanceOf(PositiveNumberException.class);
    }

    @Test
    @DisplayName("양의 정수면 성공")
    void givenPositiveNumber_whenCreatePositiveNumber_thenSuccess() {
        // given
        // when
        // then
        assertDoesNotThrow(() -> new PositiveNumber(1));
    }
}
