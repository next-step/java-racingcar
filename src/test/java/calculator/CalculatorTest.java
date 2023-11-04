package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Calculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    @DisplayName("splitAndSum 수행 시 덧셈 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"'1',1", "'1,2',3", "'1,2:3',6", "'//;\n1;2;3',6"})
    void splitAndSum_ShouldReturnAdditionResult(String input, int expected) {
        assertThat(splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("splitAndSum 수행 시 exception 을 던진다.")
    @ParameterizedTest
    @CsvSource(value = {"'-1,2,3'", "'1,test,3'"})
    void splitAndSum_ShouldThrowsException(String input) throws Exception {
        assertThatThrownBy(() -> splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }
}