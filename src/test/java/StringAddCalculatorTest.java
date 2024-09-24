import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
public class StringAddCalculatorTest {

    private final StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void whenEmptyGivenReturnZero() {
        int result = stringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void givenIntString_shouldReturnInt(String input) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(Integer.valueOf(input));
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void givenTwoIntWithComma_shouldReturnSum() {
        String input = "1,2";
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void givenIntCanIncludeCommaAndColon() {
        String input = "1,2:3";
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(6);
    }
}
