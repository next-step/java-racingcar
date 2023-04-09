import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("1-1. 빈 문자열 입력 테스트")
    void testEmpty() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.calculate("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("1-2. Null 입력 테스트")
    void testNull() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.calculate(null);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("2. 한개 문자열 입력 테스트")
    void testOneString() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.calculate("2");

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("3. 두개 문자열 입력 테스트(구분자 ,)")
    void testTwoStringWithComma() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.calculate("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("4. 두개 문자열 입력 테스트(구분자 :)")
    void testTwoStringWithCommaAndColon() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.calculate("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("5. 커스텀 구분자 테스트(;)")
    void testTwoStringWithCustomDelimeter() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.calculate("//;\n1;2,3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("6. 음수 입력시 Exception 테스트")
    void testStringWithNegative() {
        assertThatThrownBy(() -> {
            StringCalculator stringCalculator = new StringCalculator();
            stringCalculator.calculate("//;\n1;2;-3");
        }).isInstanceOf(RuntimeException.class);
    }
}
