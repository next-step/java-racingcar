package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("null 이나 빈 문자열을 입력하면 0을 리턴한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void test1(String text) {

        assertThat(Calculator.sum(text)).isEqualTo(0);
    }

    @Test
    @DisplayName(", 구분자로 숫자를 구분하는 경우 숫자 합을 리턴한다.")
    void test2() {

        assertThat(Calculator.sum("1,2")).isEqualTo(3);
        assertThat(Calculator.sum("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 하나가 들어오면 해당 숫자를 리턴한다.")
    void test3() {

        assertThat(Calculator.sum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("; 구분자로 숫자를 구분하는 경우 숫자 합을 리턴한다.")
    void test4() {
        assertThat(Calculator.sum("1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName(",와 ; 구분자로 숫자를 구분하는 경우 숫자 합을 리턴한다.")
    void test5() {
        assertThat(Calculator.sum("1,2;3")).isEqualTo(6);
    }
}
