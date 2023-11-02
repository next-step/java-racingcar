package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("문자열을 전달 받아 기본 구분자로 문자열을 분리한 뒤 합을 구한다.")
    @Test
    void calculateWith() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String string = "1,2,3";

        // when
        int result = stringCalculator.calculateWith(string);

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("문자열을 전달 받아 커스텀 구분자를 찾고 그 구분자로 문자열을 분리한 뒤 합을 구한다.")
    @Test
    void calculateWithCustomDelimeter() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String string = "//;\n1;2;3";

        // when
        int result = stringCalculator.calculateWith(string);

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("구분자로 문자열을 분리한 뒤 배열의 요소가 양의 정수가 아니면 RuntimeException을 던진다.")
    @Test
    void calculateWhenArrayIsNotNumber() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String string = "1:2:d";

        // when & then
        assertThatThrownBy(() -> stringCalculator.calculateWith(string))
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