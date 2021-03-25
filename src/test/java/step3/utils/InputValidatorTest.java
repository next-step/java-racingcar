package step3.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputValidatorTest {
    @ParameterizedTest(name = "심볼 사이즈 검증 테스트")
    @ValueSource(strings = {"-", "*", "+", "o"})
    void validateSymbol(String symbol) {
        // given
        int expected = 1;

        // when
        String validated = InputValidator.validateSymbol(symbol);
        int actual = validated.length();

        // then
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("자동차 이름 글자수 검증 테스트")
    void validateCarName() {
        // given
        String inputName = "apple,goog,kakao,naver,cpng";

        // when
        String[] carNames = InputValidator.validateCarName(inputName);

        // then
        assertThat(carNames).contains("apple", "goog", "kakao", "naver", "cpng");
    }
}
