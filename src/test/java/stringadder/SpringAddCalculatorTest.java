package stringadder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import stringadder.delimiter.DelimiterNumberParserFactory;
import stringadder.exception.StringAddIllegalArgumentException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SpringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator(new DelimiterNumberParserFactory());
    }

    @DisplayName("null 또는 빈문자를 입력하면 결과값 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSum_null_또는_빈문자(String text) {
        assertThat(stringAddCalculator.splitAndSum(text)).isZero();
    }

    @DisplayName("한자리 숫자를 더할 수 있다.")
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3", "4,4", "5,5", "6,6", "7,7", "8,8", "9,9"})
    void splitAndSum_숫자하나(String text, int num) {
        assertThat(stringAddCalculator.splitAndSum(text)).isEqualTo(num);
    }

    @DisplayName("숫자 사이에 쉼표 구분자를 분리 해 값을 더할 수 있다.")
    @Test
    void splitAndSum_쉼표구분자() {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("숫자 사이에 쉼표 또는 콜론 구분자를 분리 해 값을 더할 수 있다.")
    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자 사이에 커스텀 구분자를 분리 해 값을 더할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {";", "!", "@", "#", "%"})
    void splitAndSum_custom_구분자(String customDelimiter) {
        int result = stringAddCalculator.splitAndSum("//" + customDelimiter + "\n1" + customDelimiter + "2" + customDelimiter + "3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수를 더하려고 할 경우 예외를 발생시킨다.")
    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(StringAddIllegalArgumentException.class);
    }
}