package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 덧셈 계산기 테스트")
public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열을 입력할 경우 0을 반환")
    void return0WhenEmptyString() {
        int actual = StringAddCalculator.sum("");
        assertThat(actual).isZero();
    }

    @Test
    @DisplayName("null 값을 입력할 경우 0을 반환")
    void return0WhenNull() {
        int actual = StringAddCalculator.sum(null);
        assertThat(actual).isZero();
    }

    @Nested
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    class SingleNumberStringCase {

        @Test
        @DisplayName("문자열 '1'를 입력하면 숫자 1를 반환")
        void returnInt1WhenInputStr1() {
            int actual = StringAddCalculator.sum("1");
            assertThat(actual).isEqualTo(1);
        }

        @Test
        @DisplayName("문자열 '9'를 입력하면 숫자 9를 반환")
        void returnInt9WhenInputStr9() {
            int actual = StringAddCalculator.sum("9");
            assertThat(actual).isEqualTo(9);
        }

    }

    @Nested
    @DisplayName("숫자 두 개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    class TwoNumberStringWithCommaCase {

        @Test
        @DisplayName("문자열 '1,2'를 입력하면 숫자 3을 반환")
        void return3When1And2ConcatWithComma() {
            int actual = StringAddCalculator.sum("1,2");
            assertThat(actual).isEqualTo(3);
        }

        @Test
        @DisplayName("문자열 '9,10'를 입력하면 숫자 3을 반환")
        void return19When9And10ConcatWithComma() {
            int actual = StringAddCalculator.sum("9,10");
            assertThat(actual).isEqualTo(19);
        }
    }

    @Test
    @DisplayName("문자열 '1,2:3'을 입력하면 숫자 6을 반환 (구분자 ,:)")
    void return6WhenInputString1CommaTowColonThree() {
        assertThat(StringAddCalculator.sum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정")
    void 커스텀_구분자_세미콜론_지정() {
        assertThat(StringAddCalculator.sum("//;\n1;2;3")).isEqualTo(6);
    }

}
