package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NameTest {

    @DisplayName("5글자 미만 정상 생성")
    @Test
    void createName() {
        assertDoesNotThrow(() -> new Name("test"));
    }

    @DisplayName("null 또는 빈 문자열을 넣으면 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void createNameNullOrEmpty(String input) {
        assertThatThrownBy(() -> new Name(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("5글자 초과 예외 발생")
    @Test
    void createNameThrowsException() {
        assertThatThrownBy(() -> new Name("nooose")).isInstanceOf(IllegalArgumentException.class);
    }
}