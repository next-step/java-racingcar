import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {


    @DisplayName("빈문자열 또는 null값을 입력한 경우 0을 반환한다. ")
    @ParameterizedTest
    @CsvSource(value = {"null,0", "'',0"}, nullValues = "null", emptyValue = "")
    void splitAndSumReturnZero(String input, Integer result) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(result);
    }
}
