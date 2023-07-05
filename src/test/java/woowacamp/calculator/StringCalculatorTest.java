package woowacamp.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import woowacamp.calculator.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)")
    void test_01(String text) {
        /* given */

        /* when */
        int result = StringCalculator.sum(text);

        /* then */
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)")
    void test_02() {
        /* given */
        String text = "1";

        /* when */
        int result = StringCalculator.sum(text);

        /* then */
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)")
    void test_03() {
        /* given */
        String text = "1,2";

        /* when */
        int result = StringCalculator.sum(text);

        /* then */
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 세미콜론(;)을 사용할 수 있다. (예 : “1,2;3” => 6)")
    void test_04() {
        /* given */
        String text = "1,2;3";

        /* when */
        int result = StringCalculator.sum(text);

        /* then */
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("“//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)")
    void test_05() {
        /* given */
        String text = "//;\n1;2;3";

        /* when */
        int result = StringCalculator.sum(text);

        /* then */
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)")
    void test_06() {
        /* given */
        String text = "-1,2,3";

        /* when & then */
        assertThatThrownBy(() -> StringCalculator.sum(text))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
