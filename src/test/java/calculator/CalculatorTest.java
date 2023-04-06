package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {

    @DisplayName("sum 메서드 - 분리한 각 숫자의 합을 반환")
    @Test
    void sum() {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.sum(Arrays.asList(1, 2, 3));

        //then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("splitAndSum 메서드 - 빈 값의 경우 0 반환")
    @Test
    void splitAndSum() {
        //given
        Calculator calculator = new Calculator();

        //when
        int result1 = calculator.splitAndSum("");
        int result2 = calculator.splitAndSum(null);

        //then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(0);
    }

    @DisplayName("splitAndSum 메서드 - 값 1개 이상인 경우")
    @ParameterizedTest
    @CsvSource(value = {"1=1","1,2=3","1:2=3","1,2,3=6","1,2:3=6"}, delimiter = '=')
    void splitAndSum2(String input, int result) {
        //given
        Calculator calculator = new Calculator();

        //when
        //then
        assertThat(calculator.splitAndSum(input)).isEqualTo(result);
    }

    @DisplayName("splitAndSum 메서드 - \"//\"와 \"\\n\" 사이에 위치하는 문자를 커스텀 구분자로 사용한 경우")
    @Test
    void splitAndSum3() {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.splitAndSum("//;\n1;2;3");

        //then
        assertThat(result).isEqualTo(6);
    }
}
