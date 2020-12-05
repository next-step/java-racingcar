package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    @DisplayName("문자열계산식 등록 - 정상적인 계산식")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 20", "1 + 20 - 300 * 4000 / 50000"})
    void create_pass(String values) {
        //when
        StringCalculator stringCalculator = new StringCalculator(values);

        //then
        assertThat(stringCalculator).isNotNull();
    }

    @DisplayName("문자열계산식 등록 - 비정상적인 계산식")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1+2", "1 . 2 $ 5", "1 ++ 2"})
    void create_fail(String values) {
        //when, then
        assertThatIllegalArgumentException()
              .isThrownBy(() -> new StringCalculator(values))
              .withMessage("잘못된 계산식입니다.");
    }

    @DisplayName("숫자와 연산자를 분리해서 저장")
    @Test
    void create() {
        //given
        String values = "10 + 2 - 3 * 4 / 5";

        //when
        StringCalculator actual = new StringCalculator(values);

        //then
        StringCalculator expected = new StringCalculator(Arrays.asList(10,2,3,4,5), Arrays.asList("+", "-", "*", "/"));
        assertEquals(expected, actual);
    }

    @DisplayName("계산")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "3 + 1 * 4:16", "5 / 2:2", "2 + 3 * 4 / 2:10"}, delimiter = ':')
    void calculate(String values, int expected) {
        //given
        StringCalculator stringCalculator = new StringCalculator(values);

        //when
        int actual = stringCalculator.calculate();

        //then
        assertEquals(actual, expected);
    }
}
