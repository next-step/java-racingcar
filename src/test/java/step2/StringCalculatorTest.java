package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("기본, 커스텀 구분자를 가진 문자열, 비어있거나 null인 문자열, 하나의 숫자만 가진 문자열의 합을 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:6", "'//;\n1;2;3':6", " :0", "1:1"}, delimiter = ':')
    void calculate(String string, int expectedResult) {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int realResult = stringCalculator.calculate(string);

        // then
        assertThat(realResult).isEqualTo(expectedResult);
    }

    @DisplayName("구분자로 문자열을 분리한 뒤 배열의 요소가 양의 정수가 아니면 RuntimeException을 던진다.")
    @Test
    void calculateWhenArrayIsNotNumber() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String string = "1:2:d";

        // when & then
        assertThatThrownBy(() -> stringCalculator.calculate(string))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("String indexOf() 학습 테스트")
    @Test
    void stringIndexOfTest() {
        // given
        String sample = "abcdef";

        // when
        int first = sample.indexOf("bc");
        int second = sample.indexOf("ef");

        // then
        assertThat(first).isEqualTo(1);
        assertThat(second).isEqualTo(4);
    }
}