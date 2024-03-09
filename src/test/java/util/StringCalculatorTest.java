package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @Test
    void test01() {
        // given
        String input = "";
        
        // when
        int result = StringCalculator.add(input);
        
        // then
        assertThat(result).isZero();
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    void test02() {
        // given
        String input = "2";

        // when
        int result = StringCalculator.add(input);

        // then
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("기본 구분자(콤마 혹은 콜론)로 구분된 숫자를 문자열 형태로 입력할 경우 각 숫자들의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"2,3-5", "3:3-6", "4,5-9"}, delimiter = '-')
    void test03(String input, int expected) {
        // when
        int result = StringCalculator.add(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자로 구분된 숫자를 문자열 형태로 입력할 경우 각 숫자들의 합을 반환한다.")
    @Test
    void test04() {
        // given
        String input = "//;\n7;8;15";

        // when
        int result = StringCalculator.add(input);

        // then
        assertThat(result).isEqualTo(30);
    }

    @DisplayName("구분자로 구분된 숫자들 중 음수가 있을 경우 RuntimeException 을 발생시킨다.")
    @Test
    void test05() {
        // given
        String input = "2,-3,5";

        // when / then
        assertThatThrownBy(() -> StringCalculator.add(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }
}