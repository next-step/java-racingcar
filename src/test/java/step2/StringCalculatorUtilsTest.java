package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorUtilsTest {
    @ParameterizedTest
    @CsvSource(value = { "2 + 3 * 4 / 2, 2+3*4/2", " a     a   a , aaa" })
    @DisplayName("공백 제거 테스트")
    void removeWhiteSpace(String param, String expected) {
        String actual = StringCalculatorUtils.removeWhiteSpace(param);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({ "'',-1,+", "-,-1,-" })
    @DisplayName("음수테스트")
    void getNegativeCheckedOperator(String operator, String number, String expected) {
        assertThat(StringCalculatorUtils.getNegativeCheckedOperator(operator, number)).isEqualTo(expected);
    }

}
