package study.step_2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step_1.StringAddCalculator;

public class StringAddCalculatorTest {

    @DisplayName(", 혹은 : 구분자와 하나 이상의 숫자를 포함하는 문자열을 전달 받았을 경우 구분자를 기준으로 분리한 각 숫자의 합을 정수형으로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2 3" , "1,2,3 6", "1:2:3 6", "1:2,4 7", "1, 1", "1: 1", ":1 1", ",1 1"}, delimiter = ' ')
    public void splitAndSum(String input, String expectResult) {
        StringAddCalculator calculator = new StringAddCalculator();
        Assertions.assertThat(calculator.splitAndSum(input)).isEqualTo(Integer.parseInt(expectResult));
    }

    @DisplayName(", 혹은 : 구분자와 하나의 숫자를 포함하는 문자열을 전달 받았을 경우에 구분자를 기준으로 분리한 숫자를 정수형으로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 1", "1: 1", ":1 1", ",1 1"}, delimiter = ' ')
    public void splitAndSum_단일문자를_입력받을떄(String input, String expectResult) {
        StringAddCalculator calculator = new StringAddCalculator();
        Assertions.assertThat(calculator.splitAndSum(input)).isEqualTo(Integer.parseInt(expectResult));
    }

    @DisplayName(", 혹은 : 구분자와 하나 이상의 숫자를 포함하지 않는 문자열을 전달 받았으면 0을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {", 0", ": 0"}, delimiter = ' ')
    public void splitAndSum_숫자를_입력받지_못했을때(String input, String expectResult) {
        StringAddCalculator calculator = new StringAddCalculator();
        Assertions.assertThat(calculator.splitAndSum(input)).isEqualTo(Integer.parseInt(expectResult));
    }

}
