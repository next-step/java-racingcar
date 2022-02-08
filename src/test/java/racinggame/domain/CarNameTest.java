package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @DisplayName("공백 문자 입력 시, exception 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void testIsBlank(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new CarName(input));
    }

    @DisplayName("5자 초과 입력 시, exception 발생")
    @ParameterizedTest
    @ValueSource(strings = { "123456", "가나다라마바", "abcdef" })
    void testIsOverMax(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new CarName(input));
    }

    @DisplayName("자동차가 이름을 잘 반환하는지 확인")
    @Test
    void testGet() {
        CarName test = new CarName("test");
        assertThat(test.get()).isEqualTo("test");
    }
}