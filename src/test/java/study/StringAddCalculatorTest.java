package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {


    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, \"1,2\" => 3, \"1,2,3\" => 6, “1,2:3” => 6)")
    void test() {
        final StringAddCalculator stringAddCalculator = new StringAddCalculator("1,2:3");

        final int add = stringAddCalculator.add();

        assertThat(add).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "| 0",
            "1| 1",
            "1,2| 3",
            "1,2,3| 6",
            "1,2:3| 6"
    }, delimiterString = "|")
    @DisplayName("문자열 덧셈 '' => 0, \"1,2\" => 3, \"1,2,3\" => 6, “1,2:3” => 6 을 반환 하여야 한다")
    void test2(String numbers, int expected) {
        final StringAddCalculator stringAddCalculator = new StringAddCalculator(numbers);

        final int add = stringAddCalculator.add();

        assertThat(add).isEqualTo(expected);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\\n1;2;3” => 6)")
    void test3 () {
        final StringAddCalculator stringAddCalculator = new StringAddCalculator("//;\n1;2;3");

        final int add = stringAddCalculator.add();

        assertThat(add).isEqualTo(6);
    }

}