package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static study.StringAddCalculator.*;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("문자열 더하기")
    void addString(){
        assertThat(add("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void emptyStringOrNull (){
        assertThat(add("")).isEqualTo(0);
        assertThat(add(null)).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)")
    @ParameterizedTest
    @CsvSource(value = {"1:1","3:3","14:14","5:5"},delimiter = ':')
    void onlyOneInput (String input, int expected){
        assertThat(add(input)).isEqualTo(expected);
    }
}
