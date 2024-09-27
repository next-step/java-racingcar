package study.step_2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step_1.StringAddCalculator;

public class StringAddCalculatorTest {

    @DisplayName(", 혹은 : 구분자와 숫자를 포함하는 문자열을 전달 받았을 경우 구분자를 기준으로 분리한 각 숫자의 합을 정수형으로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2 3" , "1,2,3 6", "1:2:3 6", "1:2,4 7"}, delimiter = ' ')
    public void splitAndSum(String input, String expectResult) {
        StringAddCalculator calculator = new StringAddCalculator();
        Assertions.assertThat(calculator.splitAndSum(input)).isEqualTo(Integer.parseInt(expectResult));
    }
}
