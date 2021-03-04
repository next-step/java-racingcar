package step_2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String Calculator Edu Test")
public class StringASMDCalculatorTest {

    @DisplayName("Simple Calculate Success")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void calculateSentenceTest (String sourceString) {
        assertThat(StringASMDCalculator.calculateSentence(sourceString))
                .isEqualTo(10);
    }

    @DisplayName("Expected Calculates Success")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 + 3 * 0 / 1:0", "12 + 38 * 2 / 25:4"}, delimiter = ':')
    void how(String sourceString, Long expected) {
        assertThat(StringASMDCalculator.calculateSentence(sourceString))
                .isEqualTo(expected);
    }

    @DisplayName("Catch Blank Failed")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void blankViolation (String sourceString) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    StringASMDCalculator.calculateSentence(sourceString);
                }).withMessageMatching(MessageConstants.IS_NULL_OR_BLANK.getMessage());
    }

    @DisplayName("Catch Null Failed")
    @Test
    void nullViolation () {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    StringASMDCalculator.calculateSentence(null);
                }).withMessageMatching(MessageConstants.IS_NULL_OR_BLANK.getMessage());
    }

    @DisplayName("Catch Not Supported Operation Failed")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 a 4 / 2"})
    void operationSignNotMatch (String sourceString) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    StringASMDCalculator.calculateSentence(sourceString);
                }).withMessageMatching(MessageConstants.NOT_MATCH_OPERATOR.getMessage());
    }

    @DisplayName("Catch Arithmetic Failed")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 0"})
    void arithmeticViolation (String sourceString) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    StringASMDCalculator.calculateSentence(sourceString);
                }).withMessageMatching(MessageConstants.DIVIDE_BY_ZERO.getMessage());
    }

    @DisplayName("Catch Wrong Sentence Failed")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * -4 / 2"})
    void sentenceViolation (String sourceString) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    StringASMDCalculator.calculateSentence(sourceString);
                }).withMessageMatching(MessageConstants.DOES_NOT_SUPPORTED.getMessage());
    }

}
