package stringadditional;

import stringadditional.commons.Constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringAdditionalCalculatorTest {

    StringAdditionalCalculator stringAdditionalCalculator;

    @BeforeEach
    void beforeEach() {
         stringAdditionalCalculator = new StringAdditionalCalculator();
    }

    @Test
    @DisplayName("빈 문자열 또는 null 값이 입력된 경우 0을 반환")
    void emptyStringInputReturnZero() {
        assertAll(
                () -> assertThat(stringAdditionalCalculator.splitAndSum(null)).isEqualTo(0),
                () -> assertThat(stringAdditionalCalculator.splitAndSum("")).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("쉽표로 문자열 구분한 결과 숫자의 합 확인하기")
    void splitStringWithComma() {
        assertThat(stringAdditionalCalculator.splitAndSum("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론으로 문자열 구분한 결과 숫자의 합 확인하기")
    void splitStringWithColon() {
        assertThat(stringAdditionalCalculator.splitAndSum("1:2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열 구분한 결과 숫자의 합 확인하기")
    void splitStringWithCustomDelimiter() {
        assertThat(stringAdditionalCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 이외의 값이 전될되는 경우의 예외처리")
    void exceptionInvalidInputValues() {
        assertThatThrownBy(() -> stringAdditionalCalculator.splitAndSum("a:b:c"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자 이외의 값 또는 음수가 입력되었습니다.");
    }

    @Test
    @DisplayName("음수가 입력된 경우 예외처리")
    void exceptionWhenNegativeNumber() {
        assertThatThrownBy(() -> stringAdditionalCalculator.splitAndSum("1,-4,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Constant.NEGATIVE_OR_NON_NUMERIC_ERR_MSG);
    }

    @Test
    @DisplayName("음수가 입력되면서 커스텀 구분자가 입력되는 경우 예외처리")
    void exceptionWhenNegativeNumberAndCustomDelimiter() {
        assertThatThrownBy(() -> stringAdditionalCalculator.splitAndSum("//;\n1;-4;3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Constant.NEGATIVE_OR_NON_NUMERIC_ERR_MSG);
    }

    @Test
    @DisplayName("하나의 숫자만 입력이 된 경우 그대로 반환")
    void inputOnlyOneNumber() {
        assertThat(stringAdditionalCalculator.splitAndSum("1")).isEqualTo(1);
    }
}
